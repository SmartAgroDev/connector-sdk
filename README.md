# connector-sdk
SDK для разработки протоколов Agroconnector

Для создания протокола, поддерживаемого приложением Agroconnector,
необходимо реализовать интерфейсы, предоставляемые SDK. Точкой
входа обработки сообщений являются интерфейсы **HttpMessageHandler** 
и **TcpMessageHandler**. 

HttpMessageHandler используется для реализации HTTP протоколов и 
содержит 1 метод:

`suspend fun onRequest(routingContext: RoutingContext)`

routingContext: RoutingContext - позволяет обработать http запрос. 
Подробнее: https://vertx.io/docs/apidocs/io/vertx/ext/web/RoutingContext.html



TcpMessageHandler используется для реализации TCP протоколов и 
содержит 1 метод: 

`fun onConnect(socket: NetSocket)`

Подробнее: https://vertx.io/docs/apidocs/io/vertx/core/net/NetSocket.html

Стоит помнить, что в handler сокета приходит не пакет данных протокола,
а некоторая последовательность байтов любой длины. Для формирования пакетов
согласно протоколу рекомендуется использовать интерфейс: 

`interface MessageInvoker { 
    fun consumeBytesFrom(
        socket: NetSocket,
        onBytes: ((Buffer) -> Unit)? = null,
        onMessage: suspend (Buffer) -> Unit)
}`

Этот интерфейс позволяет создать обертку, в которую передается сокет, 
функция, которая вызывается при получении байтов (удобно для логирования) и 
callback, в который приходит сформированный пакет данных. 
Интерфейс не обязателен к реализации, но стоит придерживаться именно его, 
так как в дальнейшем SDK может перейти на обязательное использование этого
интерфейса. 

Еще один необязательный для реализации интерфейс:

`interface MessageParser {
    fun parse(message: Buffer): ParseResult
    fun invokeIdents(message: Buffer): List<String>
}`

Он скрывает реализацию разбора сообщения протокола и предоставляет модель
**ParseResult**, которая содержит разобранные сообщения и ответ, согласно 
реализуемому протоколу. 

Для составления валидного Json сообщения необходимо использовать интерфейс
MessageBuilder. Все функции внутри него ничего не возвращают. Входными пара-
метрами являются формируемый JsonObject, в который по нужному ключу кладется 
второй параметр метода (широта, долгота и т.п.). Это базовые параметры, которые
как правило, можно получить из сообщения без дополнительной настройки объекта. 

**Сервисы**
Интерфейсы, которые не нужно реализовывать. Их реализацию предоставляет
приложение, использующее реализацию протокола. 

| Сервис            | Описание                                   |
|-------------------|--------------------------------------------|
| DeviceAuthService | Интерфейс сервиса аутентификации           |
| SaverService      | Интерфейс сервиса для сохранения сообщений |
| ServersLogService | Интерфейс сервиса для логирования событий  |


SDK содержит одну аннотацию, которой необходимо пометить класс, реализующий 
интерфейс <Tcp/Http>MessageHandler. 

`@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Protocol(
val name: String, // Кодовое имя протокола
val clientName: String, // Человекочитаемое имя протокола (выводится в UI приложения)
val icon: String, // имя файла иконки из ресурсов
val io: String // тип протокола - HTTP/TCP. Константа из объекта IOProtocols
)`







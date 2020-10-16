package sh.awtk.kamuhakari.exception

class ObjectNotFoundException(message: String, cMessage: String) : HttpException(404, message, cMessage)
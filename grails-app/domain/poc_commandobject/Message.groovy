package poc_commandobject

class Message {
    String name
    Date departure
    Long number

    static constraints = {
        name blank:false
        number nullable:true
    }
}

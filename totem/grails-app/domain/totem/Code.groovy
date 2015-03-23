package totem

class Code {

    String code
    Integer hour
    Date lastRun
    Boolean isActive

    static constraints = {
        code(maxSize: 5000)
    }
}

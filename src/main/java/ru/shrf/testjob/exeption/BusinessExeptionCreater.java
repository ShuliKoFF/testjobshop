package ru.shrf.testjob.exeption;

public class BusinessExeptionCreater {

    public static BusinessException error(String message) {
        return new BusinessException(message);
    }

    public static BusinessException entityNotFound(Object entity, Object uuid){
        return error(String.format("Entity [%s] with Uuid[%s] not found.", entity, uuid));
    }

    public static BusinessException ratingNotValid(Object rating){
        return error(String.format("Rating [%s] is not valid.", rating));
    }

    public static BusinessException finalPriceNotValid(){
        return error("Wrong final price entered");
    }

    public static BusinessException requestStatisticNotValid() {
        return error("Only one UIDI must be sent");
    }

    public static BusinessException productNotBuy(Object clientUUID, Object productUUID) {
        return error(String.format("Customer with uuid:[%s] didn't buy product with uuid[%s]", clientUUID, productUUID));
    }
}

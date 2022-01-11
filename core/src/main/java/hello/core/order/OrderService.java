package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
} // public 공개한거라 파일명이랑 인터페이스명이 같아야 한다.

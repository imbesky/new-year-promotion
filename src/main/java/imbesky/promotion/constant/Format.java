package imbesky.promotion.constant;

public class Format {
    public static final String EMPTY = "";
    public static final String BLANK = " ";
    public static final String DASH = "-";
    public static final String COMMA = ",";
    public static final String NONE = "없음";
    public static final String ORDER_FORMAT = "%s %d개";
    public static final String PRICE_FORMAT = "###,##0";
    public static final String GREETING = "새해 프로모션 플래너에 오신 것을 환영합니다! 아래의 정보를 입력해 주세요.";
    public static final String DATE_FORMAT = "yyyy-MM-DD";
    public static final String DATE_LABEL = "방문 날짜";
    public static final String DATE_NOTICE = "방문 날짜는 %s 에서 %s사이여야 합니다.";
    public static final String NUMBER_LABEL = "방문 인원";
    public static final String NUMBER_NOTICE = "최소 방문 인원은 %d명, 주중 최대 방문 인원은 %d명, 주말 최대 방문 인원은 %d명입니다.";
    public static final String MENU_BOARD = "메뉴판";
    public static final String MENU_NAME = "메뉴명";
    public static final String MENU_PRICE = "가격";
    public static final String ORDER_LABEL = "주문서";
    public static final String ORDER_FORMAT_EXAMPLE = String.format(ORDER_FORMAT, "메뉴 이름", 1);
    public static final String ORDER_NOTICE = "메뉴 주문은 방문 인원당 최소 %d개, 최대 %d개 입니다.";
    public static final String REDIRECT_NOTICE = "이전 페이지로 돌아가기";
}

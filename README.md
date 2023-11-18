# 새해 프로모션

[우아한 테크코스 6기 프리코스 미션 '크리스마스 프로모션'](https://github.com/woowacourse-precourse/java-christmas-6) 변형 문제

## 기능 요구 사항

> 이메일 형식의 기능 요구 사항을 만족해 프로그램을 만들 것

보낸 사람: 비즈니스팀 \<`biz@somecompany.io`\>  
받는 사람: 개발팀 \<`dev@somecompany.io`\>

제목: 새해 프로모션을 위한 개발 요청

안녕하세요. 비즈니스팀입니다!

다가오는 2024년을 맞이해 특별한 신년 이벤트를 진행하고자 합니다.
아래의 이벤트 계획과 내용을 잘 읽어주세요.

#### 메뉴

```
<전식>
비빔밥 BIBIM_RICE(12,000), 호박죽 PUMPKIN_PORRIDGE(6,500), 오이 무침 CUCUMBER_SALAD(4,000)

<본식>
장어구이 EEL_STEAK(52,000), 불고기 BULGOGI(36,000), 갈비찜 GALBII_STEW(45,000), 새해 특선 메뉴 NEW_YEAR_PLATTER(60,000)

<후식>
떡 RICE_CAKE(12,000), 약과 YAKGWA(5,000)

<음료>
배즙 PEAR_JUICE(5,000), 스프라이트 SPRITE(3,000), 화이트 와인 WHITE_WINE(55,000), 소주 SOJU(4,000)
```

#### 새해 이벤트 계획

- 음력 설 디데이 할인
    - 이벤트 기간: 2024.1.1 ~ 2024.2.10
    - 1,000원으로 시작하여 음력 설이 다가올수록 날마다 할인 금액이 100원씩 증가
    - 총주문 금액에서 해당 금액만큼 할인  
      (e.g. 시작일인 1월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
- 주중 할인(월요일~금요일): 주중에는 주문한 음료 메뉴 1개당 해당 메뉴 금액의 20% 할인
- 주말 할인(토요일, 일요일): 주말에는 주문한 본식 메뉴 1개당 총주문 금액의 5% 할인
- 특별 할인: 이벤트 달력에 하트가 있는 날에는 총주문 금액에서 2,024원 할인
- 증정 이벤트: 할인 전 총주문 금액이 10만 원 이상일 때 본식 메뉴 주문 개수만큼 소주 1병 증정, 할인 전 총주문 금액이 5만원 이상일 때 본식 주문 개수만큼 스프라이트 1캔 증정
- 이벤트 기간: '음력 설 디데이 할인'을 제외한 다른 이벤트는 2024.1.1 ~ 2024.2.29 동안 적용

#### 이벤트 달력

![달력](/img.png)

#### 혜택 금액에 따른 새해 멤버십 등급 부여

- 총혜택 금액에 따라 다른 멤버십 등급을 부여합니다.
  멤버십 등급에 따라 재방문시 혜택을 증정할 계획입니다.
    - 5천 원 이상: 동
    - 1만 원 이상: 은
    - 2만 원 이상: 금
    - 5만 원 이상: 백금

#### 고객에게 안내할 이벤트 주의 사항

- 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
- 주문에 전식 혹은 본식이 포함되지 않은 경우, 주문할 수 없습니다.
- 메뉴는 방문 인원당 한 번에 최대 10개까지만 주문할 수 있습니다.
  (e.g. 비빔밥-3, 불고기-1, 떡-4의 총 주문 개수는 8개)

#### '새해 맞이 이벤트 플래너' 개발 요청 사항

- 고객들이 식당에 방문할 날짜와 인원, 주문 메뉴를 미리 선택하면 이벤트 플래너가 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 실결제 금액, 새해 멤버십 내용을 보여주기를 기대합니다.
- 이벤트 기간 중 식당 예상 방문 달은 언제인가요? (숫자만 입력해 주세요!)
    - 방문할 달은 1 혹은 2의 숫자로만 입력받아 주세요.
    - 범위의 숫자가 아닌 경우, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
    - 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성해 주세요.
- 이벤트 기간 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
    - 방문할 날짜는 1월은 1 이상 31 이하, 2월은 1이상 29 이하의 숫자로만 입력받아 주세요.
    - 범위의 숫자가 아닌 경우, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
- 방문하실 인원은 몇 명인가요? (숫자만 입력해 주세요!)
    - 최소 방문 인원은 1명, 최대 방문 인원은 주중 6명, 주말 12명입니다.
    - 최소 방문 인원 이상, 최대 방문 인원 이하의 숫자가 아닌 경우 "[ERROR] 유효하지 않은 방문 인원입니다. 다시 입력해 주세요"라는 에러 메시지를 보여 주세요.
- 주문하실 메뉴와 개수를 알려 주세요. (e.g. 약과-2,갈비찜-1,화이트와인-1)
    - 고객이 메뉴판에 없는 메뉴를 입력하는 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
    - 메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요. 이외의 입력값은 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
    - 메뉴 형식이 예시와 다른 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
    - 중복 메뉴를 입력한 경우(e.g. 스프라이트-1,스프라이트-1), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
    - 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성해 주세요.
- 주문 메뉴의 출력 순서는 자유롭게 출력해 주세요.
- 총혜택 금액에 따라 부여 멤버십의 이름을 다르게 보여 주세요.
- 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
- 실결제 금액 = 할인 전 총주문 금액 - 할인 금액
- 증정 메뉴
    - 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 보여 주세요.
- 혜택 내역
    - 고객에게 적용된 이벤트 내역만 보여 주세요.
    - 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여 주세요.
    - 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력해주세요.
- 멤버십 등급
    - 멤버십 등급이 부여되지 않는 경우, "미가입"으로 보여 주세요.

#### 기대하는 '새해 맞이 이벤트 플래너'의 예시 모습

```
안녕하세요! 우테코 식당 새해 맞이 이벤트 플래너입니다.
이벤트 기간 중 식당 예상 방문 달은 언제인가요? (숫자만 입력해 주세요!)
1
이벤트 기간 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
방문하실 인원은 몇 명인가요? (숫자만 입력해 주세요!)
1
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 약과-2,갈비찜-1,화이트와인-1)
비빔밥-3,불고기-1,떡-4,배즙-2
1월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
비빔밥 3개
불고기 1개
떡 4개
배즙 2개
 
<할인 전 총주문 금액>
102,000원
 
<증정 메뉴>
소주 1개
 
<혜택 내역>
음력 설 디데이 할인: -1,200원
주중 할인: -2,000원
증정 이벤트: -4,000원
 
<총혜택 금액>
-7,200원
 
<실결제 금액>
94,800원
 
<새해 멤버십 등급>
동
```

기대하는 예시를 한 개만 들어서 설명했지만, 더 다양한 사례가 있을 것으로 예상됩니다.  
개발이 완료되는 대로 공유해 주시면, 비즈니스팀에서 1주일간 테스트를 진행하고 오픈할 예정입니다.  
1주일 뒤에 예정된 '새해 맞이 이벤트 플래너' 개발 회의에서 더 자세한 얘기를 해보면 좋겠습니다.

감사합니다. :)

---

## 프로그램 요구 사항

- `JDK 17`에서 정상적으로 작동할 것
- 시작점은 `Application`의 `main()`
- `build.gradle` 파일 변경 불가, 외부 라이브러리 사용 불가
- [자바 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 준수
- 프로그램 종료 시 `System.exit()` 호출 금지
- 인덴트 2까지
- 3항 연산자 사용 금지
- 메서드 15라인까지
- else 예약어, switch/case 사용 금지
- 단위 테스트를 구현할 것
- 잘못된 값을 입력할 경우 `IllegalArgumentExcetion` 발생시키고 "[ERROR]"로 시작하는 에러 메세지 출력 후 재입력 받기
- `InputView`, `OutputView`와 같은 입출력 담당 클래스를 별도로 구현할 것
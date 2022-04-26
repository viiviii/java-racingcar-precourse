# 레거시 코드 리팩토링하기

- 제출한 코드에서 문제가 되는 부분들을 리팩토링 해나간다

### 목표

- 더 작은 단위로 생각하는 것을 연습한다
- 구현 당시 어느 부분에서 작은 단위를 놓쳤는지 찾아내고 회고한다
- v1에서 목표한 냄새들을 제거한다
- 테스트 코드가 프로덕트 코드 흐름과 비슷해야 한다

### 회고

> 왜 코드가 산으로 갔을까?

- 💩 랜덤 값을 메서드 내부에서 생성했음
    - 테스트가 어려워짐 -> 사용하는 곳들까지 줄줄이 어려워짐 -> 테스트 코드 작성을 피하게 됨
- 💩 클래스 갯수가 늘어나는 것을 두려워했음
    - 이 부분 때문에 List<List<Result>>가 탄생해버렸고, Winners 클래스 분리를 포기했다
- 💩 모델이 뷰에 가는게 싫어짐
    - 아직 정답을 찾지 못함

### 개선 희망사항

- 랜덤 값 외부에서 주입
    - 고민
        - 외부에서 받으려면 application → controller → model → model 이런식으로 최소 4개의 클래스를 거쳐오게 되는데 이게 맞는가? 어떻게 개선 수 있을까?
- 이상한 `Game`과 `Race` 개선
    - `Winners` 분리
- `List<List<Result>`를 일급 컬렉션으로
    - 고민
        - 시도는 해봤었는데 GameResult, MoveResult, CarResult 이런식으로 Result 세쌍둥이 지옥이 열려서 제거했다
        - 이 부분을 용어라도 개선하던지 객체지향적으로 풀어낼 수 있을까?
- 문자열 `,` 포장
    - 2차 요구사항 중 하나를 지키지 않았다
- SRP와 조금 더 가까워지기

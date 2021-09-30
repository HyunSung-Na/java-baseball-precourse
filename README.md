# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
- [ ] 3자리 난수 생성
    - [ ] 1부터 9중 랜덤으로 한자의 수 생성한다.
    - [ ] 서로 다른 수로 구성되어야 한다.
- [ ] 스트라이크, 볼, 낫싱 구현
    - [ ] 같은 수 && 같은 자리 == 스트라이크
    - [ ] 같은 수 && 다른 자리 == 볼
    - [ ] 전혀 다른 수 == 낫싱
    - [ ] 전부 같은 수 == 승리
- [ ] 플레이어 숫자 입력 및 예외 처리
    - [ ] 입력
        - 게임 재시작 / 종료 입력 (시작 1, 종료 2)
        - 야구 숫자 입력 (플레이어 1부터 9까지 서로 다른 숫자 입력)
    - [ ] 예외처리
        - 입력한 숫자가 서로 다른 숫자인지
        - 입력한 값이 숫자인지
        - 입력된 값의 길이가 3인지
- [ ] 게임 구현
    - [ ] 야구 게임 한판(단위) 실행 구현
    - [ ] 야구 게임 전체적인 실행 구현
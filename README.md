<p align="center">
    <img width="200px;" src="https://raw.githubusercontent.com/woowacourse/atdd-subway-admin-frontend/master/images/main_logo.png"/>
</p>
<p align="center">
  <img alt="npm" src="https://img.shields.io/badge/npm-%3E%3D%205.5.0-blue">
  <img alt="node" src="https://img.shields.io/badge/node-%3E%3D%209.3.0-blue">
  <img alt="license" src="https://img.shields.io/github/license/woowacourse/atdd-subway-2020">
</p>

<br>

# 레벨2 최종 미션 - 지하철 노선도 애플리케이션

## 🎯 요구사항
- [프론트엔드 미션](https://github.com/woowacourse/atdd-subway-2020/blob/master/frontend-mission.md)
- [백엔드 미션](https://github.com/woowacourse/atdd-subway-2020/blob/master/backend-mission.md)

## 🤔 미션 제출 방법
- 진행 방식은 오프라인 코딩 테스트와 동일하다.
- 저장소를 Fork하여 자신의 저장소에서 미션 구현을 완료하고, Pull Request를 통해 미션을 제출한다.
- Pull Request를 보낸 후 woowa_course@woowahan.com로 메일을 발송한다.

## 😌 레벨2 최종 미션을 임하는 자세
레벨2 과정을 스스로의 힘으로 구현했다는 것을 증명하는데 집중해라
- [x] 기능 목록을 잘 작성한다.  
- [x] 자신이 구현한 기능에 대해 인수 테스트를 작성한다.
- [x] 자신이 구현한 코드에 대해 단위 테스트를 작성한다.
- [x] TDD 사이클 이력을 볼 수 있도록 커밋 로그를 잘 작성한다.
- [ ] 사용자 친화적인 예외처리를 고민한다.
- [ ] 읽기 좋은 코드를 만든다.

-> 죄송합니다...

## 🚀 Getting Started

### Install
#### npm 설치
```
cd frontend
npm install
```
> `frontend` 디렉토리에서 수행해야 합니다.

### Usage
#### webpack server 구동
```
npm run dev
```
#### application 구동
```
./gradlew bootRun
```
<br>

## 요구사항 분석
1. 요금 정보 추가
- [x] 지하철 경로 조회 시 요금을 파악할 수 있어야 한다.
- [x] 단 거리별 운임은 이용 거리 별로 차등화 된다.
    - [x] 기본 운임이 존재하여 모든 사용자에게 부과된다.
    - [x] 10~50km 초과분은 5km마다 100원의 초과 금액이 부과된다.
    - [x] 50km 초과분은 8km마다 100원의 초과 금액이 부과된다.
- [x] 노선 별로 추가 요금을 내는 경우 측정된 요금에 더한다.
    - [x] 추가 요금을 내는 노선을 여러개 탈 경우, 가장 높은 금액만 부과된다.
- [x] 로그인 된 사용자가 조회하는 경우, 연령별로 요금을 계산한다.
    - [x] 청소년 (13이상 ~ 19미만)은 350원을 공제한 금액에서 20%를 할인한다.
    - [x] 어린이 (6이상 ~ 13미만)은 350원을 공제한 금액에서 50%를 할인한다.

2. 경로 조회 기능의 문서화
- [x] 수정한 조회 기능의 문서화를 한다.
## 📝 License

This project is [MIT](https://github.com/woowacourse/atdd-subway-2020/blob/master/LICENSE.md) licensed.

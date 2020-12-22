### springboot-data-jpa

### 관계형 데이터베이스

![image](https://user-images.githubusercontent.com/18182656/102850223-4168cf80-445c-11eb-925c-2c023ec7289e.png)

### jdbc 문제점이 뭘까

- 커넥션 비용이 비싸다
- sql이 데이터베이스 벤더 마다 다르다
- 스키마를 바꾸니 코드가 너무 많이 변경된다.
- try()... 반복적인 코드가 너무 발생한다.

![image](https://user-images.githubusercontent.com/18182656/102850256-59d8ea00-445c-11eb-999e-c77eace380f3.png)

**비즈니스 로직이 없는데 코드가 굉장히 복잡하다**

### jdbc 대신 도메인 모델을 사용하려는 이유

- 메타데이터만 맵핑시켜 놓으면 sql을 쉽게 사용해 **생산성**이 좋다
- 테스트 코드를 쉽게 만들수 있어 **유지보수**에 좋다
- jdbc를 사용할때보다 **성능**이 좋다 (단일 성능이 좋진 않지만)
- 벤더에 독립적이다

## jpa 프로그래밍

코드로 살펴보기

- Entity 맵핑
- value 맵핑
- 관계형 맵핑
- jpa repository

## jpa 상태

![image](https://user-images.githubusercontent.com/18182656/102850285-6cebba00-445c-11eb-8896-277774fa600b.png)


- transient - jpa가 모르는 상태
- persistent -  jpa 가 관리중인 상태 (1차 캐시, dirty checking)
- detached - jpa 가 이제 관리 하지 않는 상태
- removed - jpa 가 관리 하고 있긴하지만 삭제한 상태

# mybatis_test
마이바티스 러닝 테스트

## SqlSession이 핵심이다.
## SqlSessionFactory로 SqlSession을 생성한다.
## sqlSessionFactory.openSession()로 트랜잭션 경계를 나타낸다. => sqlSession.commit 또는 rollback으로 마무리 지어야 한다.
## 설정을 자바로 할 수는 있으나 너무 귀찮다.
## config 파일 구성 시 각 태그 별 순서를 생각해야 한다.
>>> git update-index --assume-unchanged [파일명] 을 이용하여 Git Commit 대상에서 제외할 수 있다.
>>> 하고 나서 git rm --cached [파일명]을 입력하여 적용해주는 것이 좋다(할 때마다 충돌남).
## List의 경우 selectList 메소드로 구해올 수 있음

>>> SPOCK where @Unroll 조합 아주 좋다.
>>>> where 절에서 기대값 넣고, expect 절에서 해당 값을 검사.

## mapper 파일 생성 시 제일 위의 &lt;?xml version="1.0" encoding="UTF-8"  ?&qt; 부분에서 encoding을 먼저 정의하면 에러 무조건 version을 먼저

### SPOCK
>>>> given, setup : 해당 테스트 돌리기 전의 사전 작업(@Before). 상대적으로 위쪽에 위치
>>>> when : 테스트 코드 실행
>>>> then : 테스트 코드 결과 검증 및 예외 및 조건에 대한 결과 확인(assert 문)
>>>> expect : 테스트할 코드 실행 후 검증(when + then)

### Join 걸어보기

- [X] Mapper 인터페이스 사용해보기
>>>> @ResultMap으로 xml에 저장된 resultMap 또는 java의 @Results 중에 해당 아이디로 등록된 내역을 가져올 수 있음.
>>>> xml의 assocation은 @One과 동일(CommentMapper에서 사용)
>>>> @SelectKey 애노테이션 사용 시 xml에서의 order(before, after)의 기능을 사용하려면, before 속성을 true 또는 false 값으로 설정
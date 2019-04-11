# mybatis_test
마이바티스 러닝 테스트

## SqlSession이 핵심이다.
## SqlSessionFactory로 SqlSession을 생성한다.
## sqlSessionFactory.openSession()로 트랜잭션 경계를 나타낸다. => sqlSession.commit 또는 rollback으로 마무리 지어야 한다.
## 설정을 자바로 할 수는 있으나 너무 귀찮다.
## config 파일 구성 시 각 태그 별 순서를 생각해야 한다.
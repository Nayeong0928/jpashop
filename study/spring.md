
| 어노테이션 | 뜻 | 참고 |
| --- | --- | --- |
| `@BeforeEach` | 테스트 실행 전 무조건 실행 |  |
| `@Test` | 테스트 메소드 |  |
| `@RunWith(SpringRunner.class)` | 스프링부트와 관련된 프로젝트 |  |
| `@Transactional` | 테스트케이스에 있으면 테스트 롤백됨 | `@Rollback(false)`으로 끌 수 있음 |
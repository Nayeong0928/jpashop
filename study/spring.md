
| 어노테이션                          | 뜻                   | 참고                                                  |
|--------------------------------|---------------------|-----------------------------------------------------|
| `@BeforeEach`                  | 테스트 실행 전 무조건 실행     |                                                     |
| `@Test`                        | 테스트 메소드             |                                                     |
| `@RunWith(SpringRunner.class)` | 스프링부트와 관련된 프로젝트     |                                                     |
| `@Transactional`               | 테스트케이스에 있으면 테스트 롤백됨 | `@Rollback(false)`으로 끌 수 있음                         |
| `@Inheritance`                 | 상속 테이블 DB 저장 전략     | 종류: JOINED, SINGLE_TABLE                            |
| `@DiscriminatorColumn`         | 구분 컬럼 이름            |                                                     |
| `@DiscriminatorValue`  | 구분 컬럼에 들어갈 값        |                                                     |
| `@Enumerated` | enum 타입             | EnumType.STRING: enum 이름, EnumType.ORDINAL: enum 숫자 |
| `@OneToOne` | 일대일 매핑              |                                                     |
| `@OneToMany` | 일대다 매핑 |  |



### 엔티티 설계 시 주의점
- 변경지점이 명확하도록 @Setter은 많이 쓰지 않는 것이 좋음
- N+1 문제 예방을 위해 연관관계는 기본적으로 지연로딩(LAZY)으로 설정 권장
- 연관 엔티티를 함께 가져와야 할 때 fetch join이나 엔티티 그래프로 최적화
- 컬렉션은 필드에서 초기화하기: 하이버네이트가 엔티티를 영속화할 때 컬렉션을 하이버네이트가 제공하는 내장 컬렉션으로 변경함
  - 하이버네이트가 관리하므로 가급적 변경하지 말기
- 엔티티->테이블 네이밍 기본 규칙: 카멜 케이스->_와 소문자로 변경
- `cascade = CascadeType.ALL`: persist 전파
- 연관관계 편의 메소드: 양방향 연관관계의 일관성 맞춰줌
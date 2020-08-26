package table;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableTest {

  Table<Integer, Person> table;
  HashFunction<Integer> hashFunction;
  List<Person> persons;

  @BeforeEach
  void setUp() {
    hashFunction = key -> key % 100;

    persons = Lists.newArrayList(new Person(20202321, "디온", "경기도 광주"),
        new Person(20203782, "하밀", "강남"),
        new Person(20201902, "써니", "분당"),
        new Person(20202457, "알렉스", "수원"),
        new Person(20201390, "에버", "서울어디였는데...")
    );
    table = new SimpleTable<>(hashFunction);
  }

  @Test
  void 간단한_테이블_입력_테스트() {
    try {
      for (Person person : persons) {
        table.insert(person.getId(), person);
      }
    } catch (Exception e) {
      fail("입력 테스트 실패");
    }
  }

  @Test
  void 간단한_테이블_탐색_테스트() {
    for (Person person : persons) {
      table.insert(person.getId(), person);
    }

    Person searchedPerson;
    for (Person targetPerson : persons) {
      searchedPerson = table.search(targetPerson.getId());
      assertThat(searchedPerson).isNotNull().isEqualToComparingFieldByField(targetPerson);
    }
  }

  @Test
  void 간단한_테이블_삭제_테스트() {
    for (Person person : persons) {
      table.insert(person.getId(), person);
    }

    Person searchedPerson;
    for (Person targetPerson : persons) {
      searchedPerson = table.delete(targetPerson.getId());
      assertThat(searchedPerson).isNotNull().isEqualToComparingFieldByField(targetPerson);
    }
  }
}

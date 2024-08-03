package lesson.java.abstracts;

/**1. Abstract Class Weapon 가 있고 attack 이라는 추상메서드를 가진다.

 이를 구현한 Class Sward , Cane, Bow 가 있다 . 아래 내용을 출력해보세요

 ```jsx
 === 공격 시작 ===
 5번의 공격
 === 공격 종료 ===

 Sward : 검을 휘두른다
 Cane : 마법을 사용한다
 Bow : 화살을 쏜다.
 ```
 */
public abstract class Weapon {
    public void print(){
        System.out.println("공격시작");
        for(int i =0; i < 5; i++){
            this.attack();
        }
        System.out.println("공격끝");
    }
    public abstract void attack();
}

# 🚌🚖대중교통 Class 만들기  

## 소개
객체 관계를 연습하기 위해 작성한 대중교통 class입니다. 각 class들은 다음과 같은 기능들을 한다.
`Bus클래스`와 `Taxi클래스`는 `Transport클래스`로부터 상속받는다. 
1. Transport
    * 속성
      * 고유 번호 
      * 현재 승객 수
      * 최대 승객 수
      * 주유량=100
      * 상태 (운행: 0/운행x: 1) 
      * 요금

    * 기능
      * 차량 고유번호 설정
      * 숭객 추가
      * 상태 확인
      * 오일 추가

2. Bus
    * 속성
      * 최대 숭객 수=30
      * 상태=0
      * 요금=1000
    * 기능
      * 상태 변경
      * 승객 추가
      * 상태 확인 
      * 오일 추가

3. Taxi
   * 속성
     * 현재 승객 수=0
     * 최대 승객 수=4
     * 상태=0
     * 요금=3000
     * 목적지
     * 목적지까지의 거리
     * 기본 거리
     * 시간당 요금
     * 택시가 총 번 돈
   * 기능
     * 승객 추가(승객수)
     * 승객 추가(승객수, 목적지, 거리)
     * 상태 확인
     * 오일 추가
     * 누적 요금 계산

---

# 코드 설명
## 1. [Transport](https://github.com/Hiluxy/Bus_prac/blob/master/src/Bus.java)
>클래스 선언  
```java
abstract class Transport { ///
}
```
`Transport클래스`는 추상클래스(Abstract)로 선언한다. 추상메소드를 사용할 경우 반드시
추상클래스 선언을 해야 한다. -> 일반 클래스에는 추상 메소드가 있을 수 없다.  
추상클래스를 상속받은 자식클래스는 반드시 추상 메소드를 오버라이딩 해야 한다.  
  
따라서, 뒤에 나오는 `Transport클래스`의`abstract 메소드()`는 `Bus클래스`와 `Taxi클래스`에서 
오버라이딩(메소드 덮어쓰기)를 해야 한다. 
> 속성
```java  
static int trans_num=0;
int now_passenger=0;
int max_passenger;
int oil=100;
int status=0; //상태 0:운행 1:차고지행
int cost=2000;
```
`Bus클래스`와 `Taxi클래스`에 공통으로 들어갈 속성을 입력해준다.

> 기능  
```java
    Transport(){ setNum();}
        
    void setNum(){
       trans_num++;
       System.out.println("===========초기 설정===========");
       System.out.println("차량 번호: "+trans_num);
       checkStatus(status);

    }
```  
`Transport클래스` 생성시 무조건 `Transport()`가 실행되며, 이 함수는 `setNum()`을
호출하기 때문에 차량마다 고유번호가 생성된다.

* **생성자**: 객체생성과 동시에 실행하는 함수. (초기화역할)  
여기선 `Transport()`가 생성자이다.   
* 생성자 쓰는 법: 클래스명과 동일하게, 반환값은 입력하지 않아도 된다.  
예를 들어 `Transport(int n)`처럼 입력값을 받을 수 있는데, 그 땐 객체생성시 `Transport transport
=new Transport(3)`처럼 생성자 규칙대로 입력해야 한다.
* 생성자를 쓰는 경우: 객체생성시 꼭 함께 해야하는 행동을 적어주면 좋다.
* 경고) 예시가 그렇다는 거지, 이 파일에선 Transport객체를 바로 생성할 수 없다.
위에서 `Transport클래스`를 추상클래스로 선언했는데, **추상클래스는 객체로 선언할 수 없다.**
자식 클래스에서 추상클래스를 상속받고 추상메소드를 오버라이딩해서 구현을 마친 뒤,**자식클래스를 이용해서 객체를 생성해야 한다.**



```java
abstract void addPassenger(int n);
abstract void checkStatus(int status);
abstract void addOil(int add_oil);
```  
추상메소드를 사용했다. 
## 추가하고 싶은 기능
* addSpeed(int n): n km/h를 인자로 받아 스피드를 올린다. 
또는 n초동안 밟아서 그 시간만큼 속도를 올리는 함수를 작성한다.(풀리퀘스트 연습할 겸 해봐야지)
* 
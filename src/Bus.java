abstract class Transport {
    int now_passenger=0;
    static int trans_num=0;
    //메모리 공유 call by reference
    int oil=100;
    int now_speed=0;
    int add_speed;
    int max_passenger=30;
    int status=0; //상태 0:운행 1:차고지행
    int cost=2000;
    Transport(){
        setNum();
    }
    void setNum(){
       trans_num++;
       System.out.println("===========초기 설정===========");
       System.out.println("차량 번호: "+trans_num);
       checkStatus(status);

    }
    void changeSpeed(){

    }

    abstract void checkStatus(int status);



    abstract void addOil(int add_oil);
    abstract void addPassenger(int n);
}


class Bus extends Transport{
    int max_passenger=30;
    int status=0; //상태 0:운행 1:차고지행
    int cost=1000;
    void driveBus(){

    }
    void changeStatus(String status){
        if(status.equals("운행중")){
            this.status=0;
        } else if(status.equals("차고지행")){
            this.status=1;
        }
        checkStatus(this.status);
    }
    @Override
    void checkStatus(int status){
        String status_word="운행 중";
        if(status==1){
            status_word="차고지행";
        }
        System.out.println("상태: "+status_word+" (변경됨)");
    }
    @Override
    void addPassenger(int n){
        System.out.println("===========승객 추가===========");
        if(now_passenger+n>30){
            System.out.println("경고: 승객수 초과, 탑승 불가");
        }
        else {
            now_passenger += n;
            System.out.println("탑승 승객 수=" + n);
            System.out.println("잔여 승객 수=" + (30 - n));
            System.out.println("요금 확인=" + n*1000+"원");
        }

    }
    @Override
    void addOil(int add_oil){
        oil+=add_oil;
        System.out.println("주유량: "+oil);
        if(0<=oil&&oil<10){
            System.out.println("*경고: 주유가 필요합니다.");
        }
        else if(oil<=0){
            status=1;
        }
    }

}

class Taxi extends Transport{

    int now_passenger=0;
    int max_passenger=4;
    int status=0; //상태 0:운행 1:차고지행
    int cost=3000;
    int oil=100;
    String destination="";
    int destination_distance=0;
    int default_distance=1;
    int per_cost=1000;
    int pocket=0;

    @Override
    void addPassenger(int n){
        now_passenger+=n;
        max_passenger-=n;
        if(max_passenger<=0){
            System.out.println("최대 승객 수 초과");
            max_passenger=4;
            now_passenger=0;
        }
        else {
            pocket += cost + (destination_distance - this.default_distance) * per_cost;


            System.out.println("탑승 승객 수=" + n);
            System.out.println("잔여 승객 수=" + max_passenger);
            System.out.println("기본 요금 확인=" + cost+"원");
            System.out.println("목적지=" + destination);
            System.out.println("목적지까지 거리=" + destination_distance + "km");
            System.out.println("지불할 요금=" + (cost + (destination_distance - this.default_distance) * per_cost)+"원");
        }
    }
    void addPassenger(int n,String destination,int d){
        destination_distance=d;
        this.destination=destination;
        now_passenger += n;
        max_passenger -= n;
        if(max_passenger<=0){
            System.out.println("최대 승객 수 초과");
            max_passenger=4;
            now_passenger=0;
        }
        else {
            pocket += cost + (d - this.default_distance) * per_cost;


            System.out.println("탑승 승객 수=" + n);
            System.out.println("잔여 승객 수=" + max_passenger);
            System.out.println("기본 요금 확인=" + cost+"원");
            System.out.println("목적지=" + destination);
            System.out.println("목적지까지 거리=" + destination_distance + "km");
            System.out.println("지불할 요금=" + (cost + (destination_distance - this.default_distance) * per_cost)+"원");
        }


    }
    @Override
    void addOil(int add_oil){
        oil+=add_oil;
        System.out.println("주유량: "+oil);
        if(0<=oil&&oil<10){
            status=1;
            System.out.println("*경고: 주유가 필요합니다.");
        }
        else if(oil<=0){
            status=1;
        }
        else{status=0;}
        checkStatus(this.status);
    }
    @Override
    void checkStatus(int status){
        String status_word="";
        if(status==1){
            status_word="운행 불가";
            System.out.println("상태: "+status_word+" (변경됨)");
        }
        else{System.out.println("상태=운행중");}

    }

    void payCost(){
        System.out.println("누적 요금="+pocket+"원");
    }

}


public class Main {
    public static void main(String[] args) {
//        Bus bus1=new Bus();
//        Bus bus2=new Bus();
//        bus1.addPassenger(2);
//        bus1.addOil(-50);
//        bus1.changeStatus("차고지행");
//        bus1.addOil(+10);
//        bus1.addPassenger(+45);
//        bus1.addPassenger(+5);
//        bus1.addOil(-55);
//        bus1.changeStatus("차고지행");

        Taxi taxi1=new Taxi();
        Taxi taxi2=new Taxi();
        taxi1.addPassenger(2,"서울역",2);
        taxi1.addOil(-80);
        taxi1.payCost();
        taxi1.addPassenger(5);
        taxi1.addPassenger(3,"구디",12);
        taxi1.addOil(-20);
        taxi1.payCost();



    }
}

package konkuk.com;

public class Lamp2 {
    boolean isOn;
    int illuminance;    // default 접근권한

    public Lamp2() {
        isOn = false;
        illuminance = 1;
    }

    public void powerOnOff(int i) {
        isOn = !isOn;
        show(i);
    }

    public void powerOnOff() {
        isOn = !isOn;
        show();
    }

    public void changeLight() {
        if (illuminance == 3) illuminance = 1;
        else illuminance++;
        System.out.println("Illuminance : "+illuminance);
    }

    public void show() {
        if (isOn) {
            System.out.println("Power On");
            System.out.println("Illuminance : "+illuminance);
        }
        else System.out.println("Power Off");
    }

    public void show(int num) {
        if (isOn) {
            System.out.println("Lamp No."+num+" Power On");
            System.out.println("Illuminance : "+illuminance);
        }
        else System.out.println("Lamp No."+num+" Power Off");
    }
}

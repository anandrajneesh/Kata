package projecteuler;

/**
 * Created by Anand_Rajneesh on 9/26/2016.
 */
public class Problem19 {

    enum DAY {
        monday(1), tuesday(2), wednesday(3), thursday(4), friday(5), saturday(6), sunday(0);

        private int i;

        DAY(int i) {
            this.i = i;
        }

        public DAY add(int days) {
            int d = (this.i + days) % 7;
            for (DAY x : DAY.values()) {
                if (x.i == d) return x;
            }
            return this;
        }
    }

    public static void main(String[] args) {
        DAY currentDay = DAY.saturday;
        int count = 0;
        for (int year = 1901; year < 2001; year++) {
            for (int month = 1; month < 13; month++) {
                switch (month) {
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                    case 2:
                    case 8:
                    case 1:
                        currentDay = currentDay.add(3);
                        break;
                    case 3:
                        if (year % 4 == 0) {
                            currentDay = currentDay.add(1);
                        }
                        break;
                    case 5:
                    case 7:
                    case 10:
                    case 12:
                        currentDay = currentDay.add(2);
                        break;
                }

                if(currentDay.equals(DAY.sunday)){
                    count++;
                }

            }

        }
        System.out.println(count);

    }
}

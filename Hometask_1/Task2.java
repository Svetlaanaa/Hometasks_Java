import java.util.Scanner;

public class Task2 {
    public static void ndsCalculation(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите цену с НДС");
        double price = Double.parseDouble(in.nextLine());
        double priceWithoutNds;
        double amountNds;
        int amountNdsTaxReturn;
        priceWithoutNds = (price * 100 / 120);
        amountNds = (price * 20 / 120);
        amountNdsTaxReturn = (int) Math.round(amountNds);
        System.out.println("Стоимость без НДС в чеке: " + (Math.round(priceWithoutNds * 100) / 100.0));
        System.out.println("Сумма НДС в чеке: " + (Math.round(amountNds * 100) / 100.0));
        System.out.println("Сумма НДС для налоговой декларации: " + amountNdsTaxReturn);
    }
    public static int wordNumber(int count){
        if(count % 10 == 1){
            if (count != 11)
                return 0;
            else
                return 2;
        }
        else if(2 <= count % 10 & count % 10 <= 4)
            if (count >= 12 & count <= 14)
                return 2;
            else
                return 1;
        else
            return 2;
    }
    public static void countdown(int count){
        if(count <= 0) System.out.println("Уже началось!");
        else{
            String[] arrayDay = new String[] {"день", "дня", "дней"};
            String[] arrayHour = new String[] {"час", "часа", "часов"};
            String[] arrayMinute = new String[] {"минута", "минуты", "минут"};
            int countDay = count / (24 * 60);
            String wordDay = arrayDay[wordNumber(countDay)];
            int countHours = ((count - countDay * 24 * 60) / 60);
            String wordHours = arrayHour[wordNumber(countHours)];
            int countMinute = (count - countDay * 24 * 60 - countHours * 60);
            String wordMinute = arrayMinute[wordNumber(countMinute)];
            System.out.print(countDay + " " + wordDay + ", ");
            System.out.print(countHours + " " + wordHours + ", ");
            System.out.print(countMinute + " " + wordMinute + ", ");
        }
    }
    public static void main(String[] args) {
        try{
            System.out.println("    №1 НДС");
            ndsCalculation();
            System.out.println("    №2 ОБРАТНЫЙ СЧЁТ");
            if(args.length > 0){
                countdown(Integer.valueOf(args[0]));
            }else{
                Scanner in = new Scanner(System.in);
                System.out.println("Введите количество часов");
                int count = Integer.parseInt(in.nextLine());
                System.out.print("Осталось: ");
                countdown(count);
            }
        }catch (NumberFormatException e){
            System.out.println("Некорректрый ввод");
        }
    }
}

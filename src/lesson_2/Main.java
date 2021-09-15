package lesson_2;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = String.valueOf(i + j);
            }
        }
        try {
            int sum = countArraySum(array);
            System.out.println(sum);
            array[3][3] = "9";
            countArraySum(array);
        } catch (MyArraySizeException e) {
            System.out.println("Массив размера 4x4");
        } catch (MyArrayDataException e) {
            System.out.println("Массив имеет неверный формат:" + e.getMessage());
        }
    }
    public static int countArraySum(String[][] array) throws MyArrayDataException, MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Значение одной из ячеек не является числом");
                }
            }
        }
        return result;
    }
}



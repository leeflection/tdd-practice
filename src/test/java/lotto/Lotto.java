package lotto;

import java.util.List;

public class Lotto {
    static final Output output = new Output();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            output.printInputDataSizeOverError();
            throw new IllegalArgumentException();
        }
        if(isDuplicated(numbers)){
            output.printDuplicationError();
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers){
        long count = numbers.stream().distinct()
                .count();
        if(count != numbers.size()){
            return true;
        }
        return false;
    }

}

package org.scoula;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.util.List;
import org.scoula.travel.domain.TravelVO;

public class CSVTest2 {
    public static void main(String[] args) throws Exception {
        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
            .withType(TravelVO.class)
            .build()
            .parse();
        travels.forEach(System.out::println);
    }
}
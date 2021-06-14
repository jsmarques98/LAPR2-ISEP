package app.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.nhs.report.Report2NHS;

public class teste {
    @Test
    public void nhs() {
        Report2NHS.writeUsingFileWriter("garstarstratat");
    }
}

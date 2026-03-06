package com.seveneleven.employeepayroll.file;

import java.io.FileWriter;
import java.io.IOException;

import com.seveneleven.employeepayroll.payroll.Payslip;

public class FileService {

    public String savePayslipAsText(Payslip payslip) throws IOException {

        String fileName = "Payslip_"
                + payslip.getEmpId()
                + "_"
                + System.currentTimeMillis()
                + ".txt";

        FileWriter fw = new FileWriter(fileName);

        fw.write(payslip.toString());

        fw.close();

        return fileName;

    }

    public String savePayslipAsPdf(Payslip payslip) throws IOException {

        String fileName = "Payslip_"
                + payslip.getEmpId()
                + "_"
                + System.currentTimeMillis()
                + ".pdf";

        FileWriter fw = new FileWriter(fileName);

        fw.write(payslip.toString());

        fw.close();

        return fileName;

    }

}
package org.aihdint.aihd.resources;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import org.aihdint.aihd.R;

public class Pdf2 extends AppCompatActivity {


    PDFView pdf2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);

        pdf2=(PDFView)findViewById(R.id.pdf_file2);
        pdf2.fromAsset("NCD QM EMS FAQs.pdf").load();
    }
}

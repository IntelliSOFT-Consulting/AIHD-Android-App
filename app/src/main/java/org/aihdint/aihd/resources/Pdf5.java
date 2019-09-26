package org.aihdint.aihd.resources;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import org.aihdint.aihd.R;

public class Pdf5 extends AppCompatActivity {

    PDFView pdf5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf5);

        pdf5=(PDFView)findViewById(R.id.pdf_file5);
        pdf5.fromAsset("Cardiovascular Guidelines 2018.pdf").load();
    }
}
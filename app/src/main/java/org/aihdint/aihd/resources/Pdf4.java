package org.aihdint.aihd.resources;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import org.aihdint.aihd.R;

public class Pdf4 extends AppCompatActivity {

    PDFView pdf4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf4);

        pdf4=(PDFView)findViewById(R.id.pdf_file4);
        pdf4.fromAsset("Diabetes Clinical Guidelines 2018.pdf").load();
    }
}
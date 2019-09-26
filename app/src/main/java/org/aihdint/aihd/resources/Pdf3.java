package org.aihdint.aihd.resources;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import org.aihdint.aihd.R;

public class Pdf3 extends AppCompatActivity {

    PDFView pdf3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf3);

        pdf3=(PDFView)findViewById(R.id.pdf_file3);
        pdf3.fromAsset("NCD QM EMS Terms & Conditions.pdf").load();
    }
}

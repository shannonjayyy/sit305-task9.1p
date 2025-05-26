package com.example.lostandfoundapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class CreateActivity extends AppCompatActivity {

    private EditText editTextName, editTextPhone, editTextDescription, editTextDate, editTextLocation;
    private RadioGroup radioGroupStatus;
    private Button buttonSave;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // Bind views
        radioGroupStatus = findViewById(R.id.radioGroupStatus);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextDate = findViewById(R.id.editTextDate);
        editTextLocation = findViewById(R.id.editTextLocation);
        buttonSave = findViewById(R.id.buttonSave);

        databaseHelper = new DatabaseHelper(this);

        buttonSave.setOnClickListener(view -> {
            String name = editTextName.getText().toString().trim();
            String phone = editTextPhone.getText().toString().trim();
            String description = editTextDescription.getText().toString().trim();
            String date = editTextDate.getText().toString().trim();
            String location = editTextLocation.getText().toString().trim();

            int selectedId = radioGroupStatus.getCheckedRadioButtonId();
            RadioButton selectedRadio = findViewById(selectedId);
            String status = selectedRadio.getText().toString();

            if (name.isEmpty() || phone.isEmpty() || description.isEmpty() || date.isEmpty() || location.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // For now: use dummy coordinates (replace with actual GPS/autocomplete values)
            double latitude = -37.8136;   // Example: Melbourne CBD
            double longitude = 144.9631;

            // Updated constructor to match LostFoundItem
            LostFoundItem item = new LostFoundItem(0, name, description, phone, date, location, status, latitude, longitude);
            databaseHelper.insertItem(item);
            Toast.makeText(this, "Advert saved!", Toast.LENGTH_SHORT).show();
            finish(); // Go back to main screen
        });
    }
}

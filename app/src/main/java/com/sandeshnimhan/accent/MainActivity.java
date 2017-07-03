/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sandeshnimhan.accent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the  TextView by id
        //NumbersOnClickListener
        TextView numbersTextView = (TextView) findViewById(R.id.numbers);
        numbersTextView.setOnClickListener(new View.OnClickListener()
        {
          @Override
            public void onClick(View view)
          {
              //Toast.makeText(view.getContext(), "Open List of Numbers", Toast.LENGTH_SHORT).show();
              Intent intent=new Intent(view.getContext(),NumbersActivity.class);
              startActivity(intent);
          }
        });

        //FamilyMembersOnClickListener
        TextView familyMembersTextView = (TextView) findViewById(R.id.family);
        familyMembersTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(view.getContext(), FamilyMembersActivity.class);
                startActivity(intent);
            }
        });

        //PhrasesOnClickListener
        TextView phrasesTextView = (TextView) findViewById(R.id.phrases);
        phrasesTextView.setOnClickListener(new View.OnClickListener()
        {
           @Override
            public void onClick(View view)
           {
               Intent intent = new Intent(view.getContext(), PhrasesActivity.class);
               startActivity(intent);
           }
        });

        //ColorsOnClickListener
        TextView colorsTextView = (TextView) findViewById(R.id.colors);
        colorsTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(view.getContext(), ColorsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void openNumbersActivity(View view)
    {
        Intent intent = new Intent(this,NumbersActivity.class);
        startActivity(intent);
        //setContentView(R.layout.activity_numbers);
    }

}

/*
 * Copyright (c) 2018 Sivan Chakravarthy
 *  *
 *  * MIT License
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  * furnished to do so, subject to the following conditions:
 *  *
 *  * The above notice shall be included in all
 *  * copies or substantial portions of the Software.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  * SOFTWARE.
 *  *
 *
 */

package retrofit.com.feedbackform_retrofit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.smile_rating1)
    SmileRating smileRating1;
    @BindView(R.id.smile_rating2)
    SmileRating smileRating2;
    @BindView(R.id.smile_rating3)
    SmileRating smileRating3;
    @BindView(R.id.smile_rating4)
    SmileRating smileRating4;
    @BindView(R.id.smile_rating5)
    SmileRating smileRating5;
    @BindView(R.id.submit_button)
    Button submitButton;


    String ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8, ans9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        smileratingset(smileRating1);
        smileratingset(smileRating2);
        smileratingset(smileRating3);
        smileratingset(smileRating4);
        smileratingset(smileRating5);


        smileRating1.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.TERRIBLE:
                        ans1 = "Poor";
                        break;

                    case SmileRating.BAD:
                        ans1 = "Fair";
                        break;

                    case SmileRating.OKAY:
                        ans1 = "Good";
                        break;

                    case SmileRating.GOOD:
                        ans1 = "Very Good";
                        break;

                    case SmileRating.GREAT:
                        ans1= "Excellent";
                        break;
                }
            }
        });


        smileRating2.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.TERRIBLE:
                        ans2 = "Poor";
                        break;

                    case SmileRating.BAD:
                        ans2 = "Fair";
                        break;

                    case SmileRating.OKAY:
                        ans2 = "Good";
                        break;

                    case SmileRating.GOOD:
                        ans2 = "Very Good";
                        break;

                    case SmileRating.GREAT:
                        ans2= "Excellent";
                        break;
                }
            }
        });


        smileRating3.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.TERRIBLE:
                        ans3 = "Poor";
                        break;

                    case SmileRating.BAD:
                        ans3 = "Fair";
                        break;

                    case SmileRating.OKAY:
                        ans3 = "Good";
                        break;

                    case SmileRating.GOOD:
                        ans3 = "Very Good";
                        break;

                    case SmileRating.GREAT:
                        ans3= "Excellent";
                        break;
                }
            }
        });


        smileRating4.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.TERRIBLE:
                        ans4 = "Poor";
                        break;

                    case SmileRating.BAD:
                        ans4 = "Fair";
                        break;

                    case SmileRating.OKAY:
                        ans4 = "Good";
                        break;

                    case SmileRating.GOOD:
                        ans4 = "Very Good";
                        break;

                    case SmileRating.GREAT:
                        ans4= "Excellent";
                        break;
                }
            }
        });

        smileRating5.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.TERRIBLE:
                        ans5 = "Poor";
                        break;

                    case SmileRating.BAD:
                        ans5 = "Fair";
                        break;

                    case SmileRating.OKAY:
                        ans5 = "Good";
                        break;

                    case SmileRating.GOOD:
                        ans5 = "Very Good";
                        break;

                    case SmileRating.GREAT:
                        ans5= "Excellent";
                        break;
                }

            }
        });


    }

    @OnClick(R.id.submit_button)
    public void onViewClicked() {
        //Submit button

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .build();

        Webservice webservice = retrofit.create(Webservice.class);
        Call<Void> call = webservice.postValues(ans1, ans2, ans3, ans4, ans5);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int responseCode = response.code();
                if (responseCode == 200) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Thank you");
                    alert.setMessage("Your response has been recorded. Thank you for your feedback.");
                    alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            smileratingClear(smileRating1);
                            smileratingClear(smileRating2);
                            smileratingClear(smileRating3);
                            smileratingClear(smileRating4);
                            smileratingClear(smileRating5);
                        }
                    });
                    alert.show();
                }
            }


            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                String throwableResponse = t.getMessage().toString();

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Failed");
                alert.setMessage("We were unable to record your response. Make sure you are connected to the internet.");
                alert.setPositiveButton("Open Settings", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       // Open Settings
                    }
                });
                alert.show();
            }


        });
    }


    private void smileratingset(SmileRating smileRating) {

        smileRating.setNameForSmile(BaseRating.TERRIBLE, "Poor");
        smileRating.setNameForSmile(BaseRating.BAD, "Fair");
        smileRating.setNameForSmile(BaseRating.OKAY, "Good");
        smileRating.setNameForSmile(BaseRating.GOOD, "Very Good");
        smileRating.setNameForSmile(BaseRating.GREAT, "Excellent");

    }

    private void smileratingClear(SmileRating smileRating) {

        smileRating.setSelectedSmile(BaseRating.NONE);

    }
}
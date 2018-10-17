# Feedback-Form-Retrofit
This app implments the idea of sending data to a google spreadsheet WITHOUT the use of the Spreadsheet API but by using the retrofit library to send simple POST calls.  

## Getting Started

This is a simple feedback application and the "Smiley Rating" library developed by sujithkanna is used to create animated smileys. A link to the library is provided at the credits section. 

## Android Goodies
### Components used

* Retrofit
* CardView
* Butterknife Injections
* Smiley Rating

### Usage

  WebService.java

```
    @POST("1FAIpQLSfIqT9HDPAX9AmmCfKYr8vbTWYh1Tt_Vw48yyoAU-S-KcGk7g/formResponse") // FORM URL
    
     Call<Void> postValues( // Entry ID of the response field for each of the question
            @Field("entry.2142461976") String ans1,
            @Field("entry.243759480") String ans2,
            @Field("entry.1254919597") String ans3,
            @Field("entry.862272373") String ans4,
            @Field("entry.1271418664") String ans5
    );
```
1.) Change the post URL in your Webservice.java to your specific form URL.

2.) To obtain the entry fields of your form, go to your form and right click on the page > View Source.

3.) This is where you find the entry field IDs for your respective form questions. 

<img src="https://user-images.githubusercontent.com/10433759/47069750-56f36680-d20d-11e8-8169-ecea58f5d834.JPG" width="500"/>

4.) Replace your entry field IDs in the WebService.java file.


### Screenshots

<img src="https://user-images.githubusercontent.com/10433759/47069865-9e79f280-d20d-11e8-908b-96438c71acd6.png" width="250" hspace="20"/><img src="https://user-images.githubusercontent.com/10433759/46907956-c846c700-cf38-11e8-9662-fa5d9be72f94.png" width="250" hspace="20"/>

Make sure you go check your response sheet after clicking on the submit button. 

## Credits

[Smiley Rating](https://github.com/sujithkanna/SmileyRating) by [Sujith Kanna](https://github.com/sujithkanna/)

JakeWharton's [Butter Knife](https://github.com/JakeWharton/butterknife)
## License 
```
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
```

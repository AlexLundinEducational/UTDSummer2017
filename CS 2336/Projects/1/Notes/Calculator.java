001
import java.awt.BorderLayout;
002
import java.awt.Color;
003
import java.awt.GridLayout;
004
import java.awt.event.ActionEvent;
005
import java.awt.event.ActionListener;
006
import java.awt.event.WindowAdapter;
007
import java.awt.event.WindowEvent;
008
 
009
import javax.swing.JButton;
010
import javax.swing.JFrame;
011
import javax.swing.JLabel;
012
import javax.swing.JPanel;
013
 
014
 
015
 
016
public class Calculator extends JFrame implements ActionListener
017
{  
018
        //Variables
019
    final int MAX_INPUT_LENGTH = 20;
020
    final int INPUT_MODE = 0;
021
    final int RESULT_MODE = 1;
022
    final int ERROR_MODE = 2;
023
    int displayMode;
024
    boolean clearOnNextDigit, percent;
025
    double lastNumber;
026
    String lastOperator;
027
    private JLabel jlOutput;
028
    private JButton jbButtons[];
029
    private JPanel jpMaster, jpControl;
030
     
031
     
032
        //Constructor
033
    public Calculator()
034
    {
035
        //GridLayout(int rows, int cols, int hgap, int vgap)
036
             
037
            //Layout Manager
038
        setBackground(Color.gray);
039
        jpMaster = new JPanel();
040
        jlOutput = new JLabel("0");
041
        jlOutput.setHorizontalTextPosition(JLabel.LEFT);
042
        jlOutput.setBackground(Color.white);
043
        jlOutput.setOpaque(true);
044
         
045
            //Frame components
046
        getContentPane().add(jlOutput, BorderLayout.NORTH);
047
        jbButtons = new JButton[27];
048
         
049
            //Container for JButton
050
        JPanel jpButtons = new JPanel();
051
         
052
            //Numeric Buttons
053
        for (int i = 0; i <= 9; i++)
054
        {
055
                //Label each button by index
056
            jbButtons[i] = new JButton(String.valueOf(i));
057
        }
058
         
059
            //Operator Buttons
060
        jbButtons[10] = new JButton("+/-");
061
        jbButtons[11] = new JButton(".");
062
        jbButtons[12] = new JButton("=");
063
        jbButtons[13] = new JButton("/");
064
        jbButtons[14] = new JButton("*");
065
        jbButtons[15] = new JButton("-");
066
        jbButtons[16] = new JButton("+");
067
        jbButtons[17] = new JButton("sqrt");
068
        jbButtons[18] = new JButton("%");
069
        jbButtons[19] = new JButton("1/x");
070
         
071
            //Function Buttons
072
        jbButtons[20] = new JButton("MC");
073
        jbButtons[21] = new JButton("MR");
074
        jbButtons[22] = new JButton("MS");
075
        jbButtons[23] = new JButton("M+");
076
        jbButtons[24] = new JButton("Backspace");
077
        jbButtons[25] = new JButton("CE");
078
        jbButtons[26] = new JButton("C");
079
         
080
            //Calculator Layout
081
        jpControl = new JPanel();
082
        jpControl.setLayout(new GridLayout(1, 3, 2, 2));
083
        jpControl.add(jbButtons[24]);
084
        jpControl.add(jbButtons[25]);
085
        jpControl.add(jbButtons[26]);
086
         
087
                //Text color
088
        for (int i = 0; i < jbButtons.length; i++)
089
        {
090
            if (i < 10)
091
                jbButtons[i].setForeground(Color.blue);
092
            else
093
                jbButtons[i].setForeground(Color.red);
094
        }
095
         
096
                //4 by 6 grid
097
        jpButtons.setLayout(new GridLayout(4, 6, 2, 2));
098
         
099
                //First Row
100
        jpButtons.add(jbButtons[20]);  //MC button
101
        for (int i = 7; i <= 9; i++)  //7, 8, 9 buttons
102
        {
103
            jpButtons.add(jbButtons[i]);
104
        }
105
        jpButtons.add(jbButtons[13]);  //Division button
106
        jpButtons.add(jbButtons[17]);  //Square Root button
107
         
108
                //Second Row
109
        jpButtons.add(jbButtons[21]);  //MR button
110
        for (int i = 4; i <= 6; i++)
111
        {
112
            jpButtons.add(jbButtons[i]);  //4, 5, 6 buttons
113
        }
114
        jpButtons.add(jbButtons[14]);  //Multiplication button
115
        jpButtons.add(jbButtons[18]);  //Percentage button
116
         
117
                //Third Row
118
        jpButtons.add(jbButtons[22]);  //MS button
119
        for (int i = 1; i <= 3; i++)
120
        {
121
            jpButtons.add(jbButtons[i]);  //1, 2, 3 buttons
122
        }
123
        jpButtons.add(jbButtons[15]);  //Subtraction button
124
        jpButtons.add(jbButtons[19]);  //Reciprical button
125
         
126
                //Fourth Row
127
        jpButtons.add(jbButtons[23]);  //M+ button
128
        jpButtons.add(jbButtons[0]);  //0 button
129
        jpButtons.add(jbButtons[10]);  //Positive/Negative button
130
        jpButtons.add(jbButtons[11]);  //Decimal button
131
        jpButtons.add(jbButtons[16]);  //Addition button
132
        jpButtons.add(jbButtons[12]);  //Equals button
133
         
134
        jpMaster.setLayout(new BorderLayout());
135
        jpMaster.add(jpControl, BorderLayout.EAST);
136
        jpMaster.add(jpButtons, BorderLayout.SOUTH);
137
         
138
                //Components to Frame
139
        getContentPane().add(jpMaster, BorderLayout.SOUTH);
140
        requestFocus();
141
         
142
                //Activate ActionListener
143
        for (int i = 0; i < jbButtons.length; i++)
144
        {
145
            jbButtons[i].addActionListener(this);
146
        }
147
     
148
        clearAll();
149
         
150
                //Closing and Ending
151
        addWindowListener(new WindowAdapter()
152
        {
153
            public void windowClosed(WindowEvent e)
154
            {
155
                System.exit(0);
156
            }
157
        });
158
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
159
    }
160
     
161
        //Actions
162
    public void actionPerformed(ActionEvent e)
163
    {
164
        double result = 0;
165
         
166
            //Search for entered key
167
        for (int i = 0; i < jbButtons.length; i++)
168
        {
169
            if(e.getSource() == jbButtons[i])
170
            {
171
                switch(i)
172
                {
173
                    case 0:
174
                        addDigitToDisplay(i);
175
                        break;
176
                         
177
                    case 1:
178
                        addDigitToDisplay(i);
179
                        break;
180
                         
181
                    case 2:
182
                        addDigitToDisplay(i);
183
                        break;
184
                         
185
                    case 3:
186
                        addDigitToDisplay(i);
187
                        break;
188
                     
189
                    case 4:
190
                        addDigitToDisplay(i);
191
                        break;
192
                         
193
                    case 5:
194
                        addDigitToDisplay(i);
195
                        break;
196
                         
197
                    case 6:
198
                        addDigitToDisplay(i);
199
                        break;
200
                         
201
                    case 7:
202
                        addDigitToDisplay(i);
203
                        break;
204
                         
205
                    case 8:
206
                        addDigitToDisplay(i);
207
                        break;
208
                         
209
                    case 9:
210
                        addDigitToDisplay(i);
211
                        break;
212
                         
213
                    case 10:
214
                        processSignChange();
215
                        break;
216
                         
217
                    case 11:
218
                        addDecimalPoint();
219
                        break;
220
                         
221
                    case 12:
222
                        processEquals();
223
                        break;
224
                         
225
                    case 13:
226
                        processOperator("/");
227
                        break;
228
                         
229
                    case 14:
230
                        processOperator("*");
231
                        break;
232
                         
233
                    case 15:
234
                        processOperator("-");
235
                        break;
236
                         
237
                    case 16:
238
                        processOperator("+");
239
                        break;
240
                         
241
                    case 17:
242
                        if (displayMode != ERROR_MODE)
243
                        {
244
                            try
245
                            {
246
                                if (getDisplayString().indexOf("-") == 0)
247
                                    displayError("Invalid input for function.");
248
                                 
249
                                result = Math.sqrt(getNumberInDisplay());
250
                                displayResult(result);
251
                            }
252
                            catch(Exception ex)
253
                            {
254
                                displayError("Invalid input for function.");
255
                                displayMode = ERROR_MODE;
256
                            }
257
                        }
258
                        break;
259
                         
260
                    case 18:
261
                        if (displayMode != ERROR_MODE)
262
                        {
263
                            try
264
                            {
265
                                result = getNumberInDisplay() / 100;
266
                                displayResult(result);
267
                            }
268
                            catch(Exception ex)
269
                            {
270
                                displayError("Invalid input for function.");
271
                                displayMode = ERROR_MODE;
272
                            }
273
                        }
274
                        break;
275
                         
276
                    case 19:
277
                        if (displayMode != ERROR_MODE)
278
                        {
279
                            try
280
                            {
281
                                if (getNumberInDisplay() == 0)
282
                                    displayError("Cannot divide by zero.");
283
                                result = 1 / getNumberInDisplay();
284
                                displayResult(result);
285
                            }
286
                            catch(Exception ex)
287
                            {
288
                                displayError("Cannot divide by zero.");
289
                                displayMode = ERROR_MODE;
290
                            }
291
                        }
292
                        break;
293
                         
294
                    case 20:
295
                        clearMemory();
296
                        break;
297
                         
298
                    case 21:
299
                        recallMemory();
300
                        break;
301
                         
302
                    case 22:
303
                        storeInMemory();
304
                        break;
305
                         
306
                    case 23:
307
                        addToMemory();
308
                        break;
309
                         
310
                    case 24:
311
                        if (displayMode != ERROR_MODE)
312
                        {
313
                            setDisplayString(getDisplayString().substring(0, getDisplayString().length() - 1));
314
                            if (getDisplayString().length() < 1)
315
                                setDisplayString("0");
316
                        }
317
                        break;
318
                         
319
                    case 25:
320
                        clearExisting();
321
                        break;
322
                         
323
                    case 26:
324
                        clearAll();
325
                        break;
326
                    }
327
                }
328
            }
329
        }
330
         
331
        private void addToMemory()
332
        {
333
        //needs code   
334
         
335
        }
336
 
337
        private void storeInMemory()
338
        {
339
        //needs code   
340
        }
341
 
342
        private void recallMemory()
343
        {
344
        //needs code
345
        }
346
 
347
        private void clearMemory()
348
        {
349
        //needs code
350
        }
351
 
352
        void setDisplayString(String s)
353
        {
354
            jlOutput.setText(s);
355
        }
356
         
357
        String getDisplayString()
358
        {
359
            return jlOutput.getText();
360
        }
361
         
362
        void addDigitToDisplay(int digit)
363
        {
364
            if (clearOnNextDigit)
365
            {
366
                setDisplayString("");
367
            }
368
            String inputString = getDisplayString();
369
            if (inputString.indexOf("0") == 0)
370
            {
371
                inputString = inputString.substring(1);
372
            }
373
            if ((!inputString.equals("0") || digit > 0) && inputString.length() < MAX_INPUT_LENGTH)
374
            {
375
                setDisplayString(inputString + digit);
376
            }
377
            displayMode = INPUT_MODE;
378
            clearOnNextDigit = false;
379
        }
380
         
381
        void addDecimalPoint()
382
        {
383
            displayMode = INPUT_MODE;
384
            if (clearOnNextDigit)
385
            {
386
                setDisplayString("");
387
            }
388
            String inputString = getDisplayString();
389
            if (inputString.indexOf(".") < 0)
390
            {
391
                setDisplayString(new String(inputString + "."));
392
            }
393
        }
394
         
395
        void processSignChange()
396
        {
397
            if (displayMode == INPUT_MODE)
398
            {
399
                String input = getDisplayString();
400
                if (input.length() > 0 && !input.equals("0"))
401
                {
402
                    if(input.indexOf("-") == 0)
403
                    {
404
                        setDisplayString(input.substring(1));
405
                    }
406
                    else
407
                    {
408
                        setDisplayString("-" + input);
409
                    }
410
                }
411
            }
412
        }
413
         
414
        void clearAll()
415
        {
416
            setDisplayString("0");
417
            lastOperator = "0";
418
            lastNumber = 0;
419
            displayMode = INPUT_MODE;
420
            clearOnNextDigit = true;
421
        }
422
         
423
        void clearExisting()
424
        {
425
            setDisplayString("0");
426
            clearOnNextDigit = true;
427
            displayMode = INPUT_MODE;
428
        }
429
         
430
        double getNumberInDisplay()
431
        {
432
            String input = jlOutput.getText();
433
            return Double.parseDouble(input);
434
        }
435
         
436
        void processOperator(String op)
437
        {
438
            if (displayMode != ERROR_MODE)
439
            {
440
                double numberInDisplay = getNumberInDisplay();
441
                if (!lastOperator.equals("0"))
442
                {
443
                    try
444
                    {
445
                        double result = processLastOperator();
446
                        displayResult(result);
447
                        lastNumber = result;
448
                    }
449
                    catch (DivideByZeroException e)
450
                    {
451
                        displayError("Cannot divide by sero.");
452
                    }
453
                }
454
                else
455
                {
456
                    lastNumber = numberInDisplay;
457
                }
458
                clearOnNextDigit = true;
459
                lastOperator = op;
460
            }
461
        }
462
         
463
        void processEquals()
464
        {
465
            double result= 0;
466
            if (displayMode != ERROR_MODE)
467
            {
468
                try
469
                {
470
                    result = processLastOperator();
471
                    displayResult(result);
472
                }
473
                catch (DivideByZeroException e)
474
                {
475
                    displayError("Cannot divide by sero.");
476
                }
477
                lastOperator = "0";
478
            }
479
        }
480
         
481
        double processLastOperator() throws DivideByZeroException
482
        {
483
            double result = 0;
484
            double numberInDisplay = getNumberInDisplay();
485
            if (lastOperator.equals("/"))
486
            {
487
                if (numberInDisplay == 0)
488
                {
489
                    throw (new DivideByZeroException());
490
                }
491
                result = lastNumber/numberInDisplay;
492
            }
493
            if (lastOperator.equals("*"))
494
            {
495
                result = lastNumber * numberInDisplay;
496
            }
497
            if (lastOperator.equals("-"))
498
            {
499
                result = lastNumber - numberInDisplay;
500
            }
501
            if (lastOperator.equals("+"))
502
            {
503
                result = lastNumber + numberInDisplay;
504
            }
505
            return result;
506
        }
507
         
508
        void displayResult(double result)
509
        {
510
            setDisplayString(Double.toString(result));
511
            lastNumber = result;
512
            displayMode = RESULT_MODE;
513
            clearOnNextDigit = true;
514
        }
515
         
516
        void displayError(String errorMessage)
517
        {
518
            setDisplayString(errorMessage);
519
            lastNumber = 0;
520
            displayMode = ERROR_MODE;
521
            clearOnNextDigit = true;
522
        }
523
         
524
        public static void main(String args[])
525
        {
526
            Calculator calc = new Calculator();
527
            calc.setTitle("Calculator");
528
            calc.setSize(240, 200);
529
            calc.pack();
530
            calc.setLocation(400, 300);
531
            calc.setVisible(true);
532
            calc.setResizable(false);
533
        }
534
}
535
 
536
class DivideByZeroException extends Exception
537
{
538
    public DivideByZeroException()
539
    {
540
        super();
541
    }
542
    public DivideByZeroException(String s)
543
    {
544
        super(s);
545
    }
546
}

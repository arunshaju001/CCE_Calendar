package sema4.com.CCE_HOLISTIC_CALENDAR;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CompactCalendarTab extends Fragment {

    private static final String TAG = "MainActivity";
    private Calendar currentCalender = Calendar.getInstance(Locale.getDefault());
    private SimpleDateFormat dateFormatForDisplaying = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.getDefault());
    private SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("MMM - yyyy", Locale.getDefault());
    private boolean shouldShow = false;
    private CompactCalendarView compactCalendarView;
    private ActionBar toolbar;
    FirebaseDatabase database;
    DatabaseReference myRef1;
    DatabaseReference myRef2;
    DatabaseReference myRef3;
    DatabaseReference myRef4;
    DatabaseReference myRef5;
    ArrayList<String> month1=new ArrayList<>();
    ArrayList<String> month2=new ArrayList<>();
    ArrayList<String> month3=new ArrayList<>();
    ArrayList<String> month4=new ArrayList<>();
    ArrayList<String> month5=new ArrayList<>();
    ProgressDialog progress;




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainTabView = inflater.inflate(R.layout.main_tab,container,false);


        database = FirebaseDatabase.getInstance();
        myRef1 = database.getReference().child("august");
        myRef2 = database.getReference().child("september");
        myRef3 = database.getReference().child("october");
        myRef4 = database.getReference().child("november");
        myRef5 = database.getReference().child("december");



        // myRef1.setValue("Hello, World!");


        // [END write_message]

        // [START read_message]
        // Read from the da


        final List<String> mutableBookings = new ArrayList<>();
//        currentCalender.set(2019,Calendar.JULY,1);
        final ListView bookingsListView = mainTabView.findViewById(R.id.bookings_listview);
        final Button showPreviousMonthBut = mainTabView.findViewById(R.id.prev_button);
        final Button showNextMonthBut = mainTabView.findViewById(R.id.next_button);
        final Button slideCalendarBut = mainTabView.findViewById(R.id.slide_calendar);
        final Button showCalendarWithAnimationBut = mainTabView.findViewById(R.id.show_with_animation_calendar);
        final Button setLocaleBut = mainTabView.findViewById(R.id.set_locale);
        final Button removeAllEventsBut = mainTabView.findViewById(R.id.remove_all_events);

        final ArrayAdapter adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, mutableBookings);

        bookingsListView.setAdapter(adapter);
        compactCalendarView = mainTabView.findViewById(R.id.compactcalendar_view);

//        compactCalendarView.set;

        // below allows you to configure color for the current day in the month
        // compactCalendarView.setCurrentDayBackgroundColor(getResources().getColor(R.color.black));
        // below allows you to configure colors for the current day the user has selected
         compactCalendarView.setCurrentSelectedDayBackgroundColor(getResources().getColor(R.color.light_blue));
        compactCalendarView.setUseThreeLetterAbbreviation(false);
        compactCalendarView.setFirstDayOfWeek(Calendar.MONDAY);
        compactCalendarView.setIsRtl(false);
        compactCalendarView.displayOtherMonthDays(false);
        //compactCalendarView.setIsRtl(true);
//        loadEvents();

        //Create a progress bar for loding from firebase
        progress = ProgressDialog.show(getContext(), "Please Wait",
                "Fetching data", true);


        //check internet connectivity
        new Thread(new Runnable() {
            public void run(){

                if (isInternetAvailable("8.8.8.8", 53, 1000)) {
                    // Internet available, do something
                } else {
                    Toast("An Internet Connection is Required");
                    progress.dismiss();


                }

            }
        }).start();





        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                // Log.d(TAG, "Value is: " + value);
                //Toast.makeText(getContext(),value,Toast.LENGTH_LONG).show();
                Post post1 = dataSnapshot.getValue(Post.class);




                month1.add(post1.day1);
                month1.add(post1.day2);
                month1.add(post1.day3);
                month1.add(post1.day4);
                month1.add(post1.day5);
                month1.add(post1.day6);
                month1.add(post1.day7);
                month1.add(post1.day8);
                month1.add(post1.day9);
                month1.add(post1.day10);
                month1.add(post1.day11);
                month1.add(post1.day12);
                month1.add(post1.day13);
                month1.add(post1.day14);
                month1.add(post1.day15);
                month1.add(post1.day16);
                month1.add(post1.day17);
                month1.add(post1.day18);
                month1.add(post1.day19);
                month1.add(post1.day20);
                month1.add(post1.day21);
                month1.add(post1.day22);
                month1.add(post1.day23);
                month1.add(post1.day24);
                month1.add(post1.day25);
                month1.add(post1.day26);
                month1.add(post1.day27);
                month1.add(post1.day28);
                month1.add(post1.day29);
                month1.add(post1.day30);
                month1.add(post1.day31);



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                // Log.d(TAG, "Value is: " + value);
                //Toast.makeText(getContext(),value,Toast.LENGTH_LONG).show();
                Post post2 = dataSnapshot.getValue(Post.class);




                month2.add(post2.day1);
                month2.add(post2.day2);
                month2.add(post2.day3);
                month2.add(post2.day4);
                month2.add(post2.day5);
                month2.add(post2.day6);
                month2.add(post2.day7);
                month2.add(post2.day8);
                month2.add(post2.day9);
                month2.add(post2.day10);
                month2.add(post2.day11);
                month2.add(post2.day12);
                month2.add(post2.day13);
                month2.add(post2.day14);
                month2.add(post2.day15);
                month2.add(post2.day16);
                month2.add(post2.day17);
                month2.add(post2.day18);
                month2.add(post2.day19);
                month2.add(post2.day20);
                month2.add(post2.day21);
                month2.add(post2.day22);
                month2.add(post2.day23);
                month2.add(post2.day24);
                month2.add(post2.day25);
                month2.add(post2.day26);
                month2.add(post2.day27);
                month2.add(post2.day28);
                month2.add(post2.day29);
                month2.add(post2.day30);
                month2.add(post2.day31);



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                // Log.d(TAG, "Value is: " + value);
                //Toast.makeText(getContext(),value,Toast.LENGTH_LONG).show();
                Post post3 = dataSnapshot.getValue(Post.class);

                month3. add(post3.day1);
                month3.add(post3.day2);
                month3.add(post3.day3);
                month3.add(post3.day4);
                month3.add(post3.day5);
                month3.add(post3.day6);
                month3.add(post3.day7);
                month3.add(post3.day8);
                month3.add(post3.day9);
                month3.add(post3.day10);
                month3.add(post3.day11);
                month3.add(post3.day12);
                month3.add(post3.day13);
                month3.add(post3.day14);
                month3.add(post3.day15);
                month3.add(post3.day16);
                month3.add(post3.day17);
                month3.add(post3.day18);
                month3.add(post3.day19);
                month3.add(post3.day20);
                month3.add(post3.day21);
                month3.add(post3.day22);
                month3.add(post3.day23);
                month3.add(post3.day24);
                month3.add(post3.day25);
                month3.add(post3.day26);
                month3.add(post3.day27);
                month3.add(post3.day28);
                month3.add(post3.day29);
                month3.add(post3.day30);
                month3.add(post3.day31);



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        myRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                // Log.d(TAG, "Value is: " + value);
                //Toast.makeText(getContext(),value,Toast.LENGTH_LONG).show();
                Post post4 = dataSnapshot.getValue(Post.class);

                month4. add(post4.day1);
                month4.add(post4.day2);
                month4.add(post4.day3);
                month4.add(post4.day4);
                month4.add(post4.day5);
                month4.add(post4.day6);
                month4.add(post4.day7);
                month4.add(post4.day8);
                month4.add(post4.day9);
                month4.add(post4.day10);
                month4.add(post4.day11);
                month4.add(post4.day12);
                month4.add(post4.day13);
                month4.add(post4.day14);
                month4.add(post4.day15);
                month4.add(post4.day16);
                month4.add(post4.day17);
                month4.add(post4.day18);
                month4.add(post4.day19);
                month4.add(post4.day20);
                month4.add(post4.day21);
                month4.add(post4.day22);
                month4.add(post4.day23);
                month4.add(post4.day24);
                month4.add(post4.day25);
                month4.add(post4.day26);
                month4.add(post4.day27);
                month4.add(post4.day28);
                month4.add(post4.day29);
                month4.add(post4.day30);
                month4.add(post4.day31);



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        myRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                // Log.d(TAG, "Value is: " + value);
                //Toast.makeText(getContext(),value,Toast.LENGTH_LONG).show();
                Post post5 = dataSnapshot.getValue(Post.class);



                month5. add(post5.day1);
                month5.add(post5.day2);
                month5.add(post5.day3);
                month5.add(post5.day4);
                month5.add(post5.day5);
                month5.add(post5.day6);
                month5.add(post5.day7);
                month5.add(post5.day8);
                month5.add(post5.day9);
                month5.add(post5.day10);
                month5.add(post5.day11);
                month5.add(post5.day12);
                month5.add(post5.day13);
                month5.add(post5.day14);
                month5.add(post5.day15);
                month5.add(post5.day16);
                month5.add(post5.day17);
                month5.add(post5.day18);
                month5.add(post5.day19);
                month5.add(post5.day20);
                month5.add(post5.day21);
                month5.add(post5.day22);
                month5.add(post5.day23);
                month5.add(post5.day24);
                month5.add(post5.day25);
                month5.add(post5.day26);
                month5.add(post5.day27);
                month5.add(post5.day28);
                month5.add(post5.day29);
                month5.add(post5.day30);
                month5.add(post5.day31);

                loadEventsForYear(2019);
                progress.dismiss();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });






        compactCalendarView.invalidate();

        logEventsByMonth(compactCalendarView);

        // below line will display Sunday as the first day of the week
//         compactCalendarView.setShouldShowMondayAsFirstDay(false);

        // disable scrolling calendar
        // compactCalendarView.shouldScrollMonth(false);

        // show days from other months as greyed out days
        // compactCalendarView.displayOtherMonthDays(true);

        // show Sunday as first day of month
//         compactCalendarView.setShouldShowMondayAsFirstDay(false);
//set initial title
        toolbar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        toolbar.setTitle(dateFormatForMonth.format(compactCalendarView.getFirstDayOfCurrentMonth()));

        //set title on calendar scroll
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                toolbar.setTitle(dateFormatForMonth.format(dateClicked));
                List<Event> bookingsFromMap = compactCalendarView.getEvents(dateClicked);
                Log.d(TAG, "inside onclick " + dateFormatForDisplaying.format(dateClicked));
                if (bookingsFromMap != null) {
                    Log.d(TAG, bookingsFromMap.toString());
                    mutableBookings.clear();
                    for (Event booking : bookingsFromMap) {
                        mutableBookings.add((String) booking.getData());
                    }
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                toolbar.setTitle(dateFormatForMonth.format(firstDayOfNewMonth));
                onDayClick(firstDayOfNewMonth);
            }
        });

        showPreviousMonthBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compactCalendarView.scrollLeft();
            }
        });

        showNextMonthBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compactCalendarView.scrollRight();
            }
        });

        final View.OnClickListener showCalendarOnClickLis = getCalendarShowLis();
        slideCalendarBut.setOnClickListener(showCalendarOnClickLis);

        final View.OnClickListener exposeCalendarListener = getCalendarExposeLis();
        showCalendarWithAnimationBut.setOnClickListener(exposeCalendarListener);

        compactCalendarView.setAnimationListener(new CompactCalendarView.CompactCalendarAnimationListener() {
            @Override
            public void onOpened() {
            }

            @Override
            public void onClosed() {
            }
        });

        setLocaleBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = Locale.FRANCE;
                dateFormatForDisplaying = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", locale);
                TimeZone timeZone = TimeZone.getTimeZone("Europe/Paris");
                dateFormatForDisplaying.setTimeZone(timeZone);
                dateFormatForMonth.setTimeZone(timeZone);
                compactCalendarView.setLocale(timeZone, locale);
                compactCalendarView.setUseThreeLetterAbbreviation(false);
//                loadEvents();
                loadEventsForYear(2019);
                logEventsByMonth(compactCalendarView);

            }
        });

        removeAllEventsBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compactCalendarView.removeAllEvents();
            }
        });


        // uncomment below to show indicators above small indicator events
        // compactCalendarView.shouldDrawIndicatorsBelowSelectedDays(true);

        // uncomment below to open onCreate
//        openCalendarOnCreate(v);

        return mainTabView;
    }

    @NonNull
    private View.OnClickListener getCalendarShowLis() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!compactCalendarView.isAnimating()) {
                    if (shouldShow) {
                        compactCalendarView.showCalendar();
                    } else {
                        compactCalendarView.hideCalendar();
                    }
                    shouldShow = !shouldShow;
                }
            }
        };
    }

    @NonNull
    private View.OnClickListener getCalendarExposeLis() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!compactCalendarView.isAnimating()) {
                    if (shouldShow) {
                        compactCalendarView.showCalendarWithAnimation();
                    } else {
                        compactCalendarView.hideCalendarWithAnimation();
                    }
                    shouldShow = !shouldShow;
                }
            }
        };
    }

    private void openCalendarOnCreate(View v) {
        final RelativeLayout layout = v.findViewById(R.id.main_content);
        ViewTreeObserver vto = layout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                compactCalendarView.showCalendarWithAnimation();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        toolbar.setTitle(dateFormatForMonth.format(compactCalendarView.getFirstDayOfCurrentMonth()));
        // Set to current day on resume to set calendar to latest day
        // toolbar.setTitle(dateFormatForMonth.format(new Date()));
    }

    private void loadEvents() {
        addEvents(-1, -1);
        addEvents(Calendar.DECEMBER, -1);
        addEvents(Calendar.AUGUST, -1);
    }

    private void loadEventsForYear(int year) {
        for(int i=7;i<12;i++)
        addEvents(i, 2019);
    }


    private void logEventsByMonth(CompactCalendarView compactCalendarView) {
        currentCalender.setTime(new Date());
        currentCalender.set(Calendar.DAY_OF_MONTH, 1);
        currentCalender.set(Calendar.MONTH, Calendar.AUGUST);
        List<String> dates = new ArrayList<>();
        for (Event e : compactCalendarView.getEventsForMonth(new Date())) {
            dates.add(dateFormatForDisplaying.format(e.getTimeInMillis()));
        }
        Log.d(TAG, "Events for Aug with simple date formatter: " + dates);
        Log.d(TAG, "Events for Aug month using default local and timezone: " + compactCalendarView.getEventsForMonth(currentCalender.getTime()));
    }

    private void addEvents(int month, int year) {
        currentCalender.setTime(new Date());
        currentCalender.set(Calendar.DAY_OF_MONTH, 1);
        int last_day= currentCalender.getActualMaximum(Calendar.DAY_OF_MONTH);
        Date firstDayOfMonth = currentCalender.getTime();
        for (int i = 0; i <last_day ; i++) {
            currentCalender.setTime(firstDayOfMonth);
            if (month > -1) {
                currentCalender.set(Calendar.MONTH, month);
            }
            if (year > -1) {
                currentCalender.set(Calendar.ERA, GregorianCalendar.AD);
                currentCalender.set(Calendar.YEAR, year);
            }
            currentCalender.add(Calendar.DATE, i);
            setToMidnight(currentCalender);
            long timeInMillis = currentCalender.getTimeInMillis();





            //List<Event> events = getEvents(timeInMillis, i);
//            String[][] data = new String[][] {{"COMMENCEMENT OF CLASSES","","VALUE ADDED PROGRAM","","","","","","FRESHERS DAY","","Holiday - BAKRID","","","","Holiday - INDEPENDENCE DAY","ADDON","ADDON","","MODULE TEST 1","","","","Holiday - SREEKRISHNA JAYANTHI","","","REMEDIAL CLASS","REMEDIAL CLASS","Holiday - AYANKALI JAYANTHI","","","ADDRESS BY PRINCIPAL/HOD"},
//                                            {"","SERIES 1","","","","ONAM CELEBRATION","Holiday - ONAM VACATION STARTS","","Holiday - MUHRAM","Holiday","Holiday","Holiday","Holiday","","","REOPENING, EXTRA ADDON","","","","PTA MEETING","Holiday - SREENARAYANA GURU SAMADHI","","REMEDIAL BASED ON SERIES 1","","","","FILM CLUB / LITERARY CLUB ACTIVITIES","","","",""},
//                                             {"","Holiday - GANDHI JAYANTHI","","VALUE ADDED PROGRAM","SPORTS DAY","","Holiday - MAHANAVAMI","","","","","","","SERIES II","","","","","SOCIALLY COMMITTED ACTIVITY","","REMEDIAL BASED ON SERIES II","","","","","","Holiday - DEEPAVALI","","","","", },
//                                             { "VALUE ADDED PROGRAM","","","","","SERIES III","","","","","","","","","CLASSES END","","","REMEDIAL CLASS STARTS","","","","","","","","","","","","","","","","","" },
//                                            {"","","","","","","","","","","","","","","","","","","","","","", "Holiday - CHRISTMAS VACATION STARTS","Holiday","Holiday - CHRISTMAS","Holiday","Holiday","","","","",}
//                                                    };

            String[][] data = new String[5][31];

            int z=0;
            for (String s:month1){

                data[0][z]=s;



                z++;


            }
            z=0;
            for (String s:month2){

                data[1][z]=s;

                z++;
            }
            z=0;
            for (String s:month3){

                data[2][z]=s;
                z++;
            }
            z=0;
            for (String s:month4){

                data[3][z]=s;
                z++;
            }
            z=0;
            for (String s:month5){

                data[4][z]=s;
                z++;

            }


            String yt;

                for (int k = 0; k < 31; k++) {


                   yt=data[2][k];
                    Log.d(TAG, "////////////////////////////////////////////////////////////////////////////////////////////////");
                    Log.d(TAG, ""+yt);

                }







            if(!data[month-7][i].equals("empty")) {
                int r=0,g=128,b=255;
                if(data[month-7][i].contains("Holiday")){
                    r=255;
                    g=0;
                    b=0;
                }
                List<Event> events = Arrays.asList(new Event(Color.argb(255, r, g, b), timeInMillis, data[month-7][i]));
                compactCalendarView.addEvents(events);
            }
        }
    }


    private void setToMidnight(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public boolean isInternetAvailable(String address, int port, int timeoutMs) {
        try {

            Socket sock = new Socket();
            SocketAddress sockaddr = new InetSocketAddress(address, port);

            sock.connect(sockaddr, timeoutMs); // This will block no more than timeoutMs
            sock.close();

            return true;

        } catch (IOException e) { return false; }
    }


    public void Toast(final String s){
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
            }
        });}


}
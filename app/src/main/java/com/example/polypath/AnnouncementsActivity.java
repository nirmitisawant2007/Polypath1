package com.example.polypath;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;



public class AnnouncementsActivity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private LinearLayout container;
    private static final String CHANNEL_ID = "poly_announce";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        container = findViewById(R.id.announcementContainer);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Announcements");
        }

        // Naye Android versions ke liye Permission maangna
        checkNotificationPermission();

        // --- DEVELOPER: ADD NEW ANNOUNCEMENTS HERE ---
        addAnnouncement("Summer 2026 Exam Forms", "Forms are now available on the portal. Deadline: Feb 12.", "14-03-2026");
        addAnnouncement("MSBTE Manuals Updated", "Check Study Material section for K-Scheme manual answers.", "10-03-2026");
        // 3rd Announcement add karne ke liye
        addAnnouncement("Urgent: Practical Exam", "External practical exams will start from April 5th. Prepare your manuals.", "15-03-2026");
        addAnnouncement("heyy hurry", "dont miss any announcements.", "14-03-2026");

        // ---------------------------------------------
    }

    private void addAnnouncement(String title, String desc, String date) {
        View v = LayoutInflater.from(this).inflate(R.layout.item_announcement, null);

        ((TextView) v.findViewById(R.id.tvAnnounceTitle)).setText(title);
        ((TextView) v.findViewById(R.id.tvAnnounceDesc)).setText(desc);
        ((TextView) v.findViewById(R.id.tvAnnounceDate)).setText(date);

        container.addView(v, 0); // Newest at top
        showNotification(title, desc);
    }

    private void showNotification(String title, String message) {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "PolyPath Alerts", NotificationManager.IMPORTANCE_HIGH);
            nm.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_popup_reminder)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        nm.notify((int) System.currentTimeMillis(), builder.build());
    }

    private void checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }
    }
}

package com.example.android.dcd_v31.Login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response;
import com.example.android.dcd_v31.MainActivity;
import com.example.android.dcd_v31.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {
    public static final String LoginSession = "LoginPrefs";
    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences settings = getSharedPreferences(LoginSession, 0);
        if (settings.getString("logged", "").toString().equals("logged")) {
            Intent goLogin3= new Intent(LoginActivity.this,MainActivity.class);
            startActivity(goLogin3);
        }
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.usernameLogin);
        populateAutoComplete();
        mPasswordView = (EditText) findViewById(R.id.passwordLogin);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void populateAutoComplete() {
        if (!mayRequestContacts()) {
            return;
        }

        getLoaderManager().initLoader(0, null, this);
    }

    private boolean mayRequestContacts() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
            Snackbar.make(mEmailView, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
                        }
                    });
        } else {
            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
        }
        return false;
    }
    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                populateAutoComplete();
            }
        }
    }
    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailView.setAdapter(adapter);
    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }

    //Represents an asynchronous login/registration task used to authenticate the user.
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            // TODO: attempt authentication against a network service.

            try {
                String mJSONURLString = "http://dcdsysteem.devomgeving.nl/api/authenticate";

                Context mContext = getApplicationContext();
                RequestQueue requestQueue = Volley.newRequestQueue(mContext);

                final String accessToken = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjcxYzFkYjljOWUxNDU2Zjk4ZDUwMzhkZWFlY2YzMDA5MGE5OGNjYmZiNTk4MjJiMDlhMDZmM2JjYTYxYTM1NGJlMzE5NTYzMzExMzE2NGFlIn0.eyJhdWQiOiIzIiwianRpIjoiNzFjMWRiOWM5ZTE0NTZmOThkNTAzOGRlYWVjZjMwMDkwYTk4Y2NiZmI1OTgyMmIwOWEwNmYzYmNhNjFhMzU0YmUzMTk1NjMzMTEzMTY0YWUiLCJpYXQiOjE1NDIxOTk2OTUsIm5iZiI6MTU0MjE5OTY5NSwiZXhwIjoxNTczNzM1Njk1LCJzdWIiOiIzIiwic2NvcGVzIjpbIioiXX0.wd4PmMbeXGorC-YujWTJkhVBHAzXW5LKfWrDLbryjTAkX9whUcd8e_uSCkUlD3YaGSzqGgKQBc8AFT2Z9Bg1LQEuuRl1mijYpZxmWZ3uKDRzaaGsxfKlEeHifXxaTeKI5hXqB_QjcowmV2NmlVXxR1WMdQlpsFTHDDzkar4PzgTSmaHvHe6NXjoSbmaVq3-T1jES9OJhr6ELHRtn1DUga1sIP614iPJKDtJH6K9FLUzcGL13-g8Z8JcWsq9_vAnyo3itL8MRl1RheQKNGIQ0sMmuiDmgxtKAnlWy9vNFu2bgmu0gtSce9QCDasRSgd8C_89_cIQPRV3rGyTzcDZD0sZ0egtPrzcQCka_5ZpD_rP7FlQVs-1SJGTLqm9RACZ07y2G09FaKmp3vDfHbo0fZNiwCg5wL2ARxaIGLweW0iAL-3mpuoonIFIblfGc4Mu14Y8MEsHZkBIE3Q45lwT0Bd-2NWKe_wCrVTiZ2ZIPnZ3YkiFxnW46sIswgSGB-cFTtu54v__XHN9YigVFBrGIA6Q83TsKHmPhV6LxwE3ia37_3aiI-aYsos6wFqiyC4rE-oHlEr_kUFJNl_Fz0EcxxOEeLz1y9gqcBk21urzAORiYrDHiBkotqHH0s0iZMtD10ooO3ct2SyTf3YLJDCazFuWSB-TLuF_6-vGxDhIW74E";

                // Initialize a new JsonArrayRequest instance
                final AutoCompleteTextView loginUser = findViewById(R.id.usernameLogin);
                {
                    String userLogin = loginUser.getText().toString();
                }
                final EditText loginPassword = findViewById(R.id.passwordLogin);
                {
                    String passwordLogin = loginPassword.getText().toString();

                    // Response
                    StringRequest eventoReq2 = new StringRequest(
                            Request.Method.POST,
                            mJSONURLString,
                            new Response.Listener<String>() {
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        Object value = jsonObject.get("access_token");
                                            SharedPreferences settings = getSharedPreferences(LoginSession, 0);
                                            SharedPreferences.Editor editor = settings.edit();
                                            editor.putString("logged", "logged");
                                            editor.commit();
                                            Intent goLogin= new Intent(LoginActivity.this,MainActivity.class);
                                            startActivity(goLogin);

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                public void onErrorResponse(VolleyError error) {
                                    // Error occurred
                                    Toast.makeText(getApplicationContext(), "Uw account of wachtwoord is onjuist", Toast.LENGTH_LONG).show();
                                    Intent stayLogin= new Intent(LoginActivity.this,LoginActivity.class);
                                    startActivity(stayLogin);
                                }
                            }) {
                        protected Map<String, String> getParams() {
                            // Posting parameters to login url
                            String userLogin = loginUser.getText().toString();
                            String passwordLogin = loginPassword.getText().toString();
                            Map<String, String> params = new HashMap<>();
                            params.put("username", userLogin);
                            params.put("password", passwordLogin);
                            return params;
                        }
                    };
                    // Add JsonArrayRequest to the RequestQueue
                    requestQueue.add(eventoReq2);
                }

                // Simulate network access.
                Thread.sleep(750);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}


package com.github.debbysa.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.debbysa.MainActivity;
import com.github.debbysa.R;

public class LoginFragment extends Fragment {
    private OnLoginFragmentListener listener;

    public void setListener(OnLoginFragmentListener listener) {
        this.listener = listener;
    }


    public interface OnLoginFragmentListener{

        void onLoginClicked(View view, String username, String password);
    }

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        final TextView usernameText = view.findViewById(R.id.text_username);
        final TextView passwordText = view.findViewById(R.id.text_password);
        Button loginButton = view.findViewById(R.id.button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                listener.onLoginClicked(view, username, password);
            }
        });

        return view;
    }

}

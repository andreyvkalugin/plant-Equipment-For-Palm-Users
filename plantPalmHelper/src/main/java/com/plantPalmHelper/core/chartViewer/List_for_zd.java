package com.github.barteksc.sample;

import android.app.ListActivity;
import android.os.Bundle;
import SQLite_Adapter.ZdAdapter;
import View_Adapter.Constants;

public class List_for_zd extends ListActivity {

    public static String[] zdMyInfo = new String[]{" пусто ",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто",
            "пусто"};
    public static final String[] zdInfo = new String[] { "задвижка №: ",
            "расположение: ",
            "номер блока: ",
            "система автоматики: ",
            "номер УСО: ",
            "номер CI: ",
            "ход запорной арматуры: ",
            "скорость modbus: ",
            "адрес modbus: ",
            "настройки modbus: ",
            "максимальный момент: ",
            "момент на закрытие: ",
            "момент для начала открытия ЗД: ",
            "момент на открытие: ",
            "момент для начала закрытия ЗД: ",
            "тип ЗД: ",
            "время на переход в режим сна: ",
            "наличие дискретных команд: ",
            "позиция открытия: ",
            "позиция закрытия: ",
            "положение по гирозонтали: ",
            "положение по вертикали: ",
            "структурная схема: ",
            "схема шкафа: ",
            "страница на структурной схеме: ",
            "страница УСО: ",
            "Резерв: ",
            "Резерв: "
    };

    public static final String[] zdPdfInfo = new String[] { "Поиск ЗД на стр. схеме",
            "Поиск ЗД в схеме шкафа"
    };

    //private ArrayList<String> zdSettingList = new ArrayList<>(Arrays.asList(zdInfo));

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zd_setting_list);
        getListView().setItemsCanFocus(true);
        ZdAdapter adapter = new ZdAdapter(this, zdInfo);
        setListAdapter(adapter);

    }

}
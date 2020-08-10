package SQLite_Adapter;

public class Zd {
    int _id;
    String _zd_name;
    String _zd_location;
    String _zd_blok_number;
    String _sa_name;
    String _uso_name;
    String _CI_number;
    String _zd_hod;
    String _zd_modbus_speed;
    String _zd_modbus_number;
    String _zd_modbus_setting;
    String _zd_max_torque;
    String _zd_torque_for_close;
    String _zd_torque_for_start_open;
    String _zd_torque_for_open;
    String _zd_torque_for_start_close;
    String _zd_type;
    String _zd_time_to_sleep;
    String _zd_discrete_command;
    String _zd_open_position;
    String _zd_close_position;
    String _zd_dimens_x;
    String _zd_dimens_y;
    String _zd_pdf_main;
    String _zd_pdf_uso;
    String _zd_pdf_main_page;
    String _zd_pdf_uso_page;
    String _zd_redundant;
    String _zd_redundant_2;

    public Zd(){
    }

    public Zd(int id, String zd_name, String zd_location, String zd_blok_number, String sa_name, String uso_name,
              String CI_number, String zd_hod, String zd_modbus_speed, String zd_modbus_number, String zd_modbus_setting,
              String zd_max_torque, String zd_torque_for_close, String zd_torque_for_start_open, String zd_torque_for_open,
              String zd_torque_for_start_close, String zd_type, String zd_time_to_sleep, String zd_discrete_command,
              String zd_open_position, String zd_close_position, String zd_dimens_x, String zd_dimens_y, String zd_pdf_main,
              String zd_pdf_uso, String zd_pdf_main_page, String zd_pdf_uso_page, String zd_redundant, String zd_redundant_2){
        this._id = id;
        this._zd_name = zd_name;
        this._zd_location = zd_location;
        this._zd_blok_number = zd_blok_number;
        this._sa_name = sa_name;
        this._uso_name = uso_name;
        this._CI_number = CI_number;
        this._zd_hod = zd_hod;
        this._zd_modbus_speed = zd_modbus_speed;
        this._zd_modbus_number = zd_modbus_number;
        this._zd_modbus_setting = zd_modbus_setting;
        this._zd_max_torque = zd_max_torque;
        this._zd_torque_for_close = zd_torque_for_close;
        this._zd_torque_for_start_open = zd_torque_for_start_open;
        this._zd_torque_for_open = zd_torque_for_open;
        this._zd_torque_for_start_close = zd_torque_for_start_close;
        this._zd_type = zd_type;
        this._zd_time_to_sleep = zd_time_to_sleep;
        this._zd_discrete_command = zd_discrete_command;
        this._zd_open_position = zd_open_position;
        this._zd_close_position = zd_close_position;
        this._zd_dimens_x = zd_dimens_x;
        this._zd_dimens_y = zd_dimens_y;
        this._zd_pdf_main = zd_pdf_main;
        this._zd_pdf_uso = zd_pdf_uso;
        this._zd_pdf_main_page = zd_pdf_main_page;
        this._zd_pdf_uso_page = zd_pdf_uso_page;
        this._zd_redundant = zd_redundant;
        this._zd_redundant_2 = zd_redundant_2;

    }

    public Zd(String zd_name, String zd_location, String zd_blok_number, String sa_name, String uso_name,
              String CI_number, String zd_hod, String zd_modbus_speed, String zd_modbus_number, String zd_modbus_setting,
              String zd_max_torque, String zd_torque_for_close, String zd_torque_for_start_open, String zd_torque_for_open,
              String zd_torque_for_start_close, String zd_type, String zd_time_to_sleep, String zd_discrete_command,
              String zd_open_position, String zd_close_position, String zd_dimens_x, String zd_dimens_y, String zd_pdf_main,
              String zd_pdf_uso, String zd_pdf_main_page, String zd_pdf_uso_page, String zd_redundant, String zd_redundant_2){
        this._zd_name = zd_name;
        this._zd_location = zd_location;
        this._zd_blok_number = zd_blok_number;
        this._sa_name = sa_name;
        this._uso_name = uso_name;
        this._CI_number = CI_number;
        this._zd_hod = zd_hod;
        this._zd_modbus_speed = zd_modbus_speed;
        this._zd_modbus_number = zd_modbus_number;
        this._zd_modbus_setting = zd_modbus_setting;
        this._zd_max_torque = zd_max_torque;
        this._zd_torque_for_close = zd_torque_for_close;
        this._zd_torque_for_start_open = zd_torque_for_start_open;
        this._zd_torque_for_open = zd_torque_for_open;
        this._zd_torque_for_start_close = zd_torque_for_start_close;
        this._zd_type = zd_type;
        this._zd_time_to_sleep = zd_time_to_sleep;
        this._zd_discrete_command = zd_discrete_command;
        this._zd_open_position = zd_open_position;
        this._zd_close_position = zd_close_position;
        this._zd_dimens_x = zd_dimens_x;
        this._zd_dimens_y = zd_dimens_y;
        this._zd_pdf_main = zd_pdf_main;
        this._zd_pdf_uso = zd_pdf_uso;
        this._zd_pdf_main_page = zd_pdf_main_page;
        this._zd_pdf_uso_page = zd_pdf_uso_page;
        this._zd_redundant = zd_redundant;
        this._zd_redundant_2 = zd_redundant_2;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_zd_name() {
        return _zd_name;
    }

    public void set_zd_name(String _zd_name) {
        this._zd_name = _zd_name;
    }

    public String get_zd_location() {
        return _zd_location;
    }

    public void set_zd_location(String _zd_location) {
        this._zd_location = _zd_location;
    }

    public String get_zd_blok_number() {
        return _zd_blok_number;
    }

    public void set_zd_blok_number(String _zd_blok_number) {
        this._zd_blok_number = _zd_blok_number;
    }

    public String get_sa_name() {
        return _sa_name;
    }

    public void set_sa_name(String _sa_name) {
        this._sa_name = _sa_name;
    }

    public String get_uso_name() {
        return _uso_name;
    }

    public void set_uso_name(String _uso_name) {
        this._uso_name = _uso_name;
    }

    public String get_CI_number() {
        return _CI_number;
    }

    public void set_CI_number(String _CI_number) {
        this._CI_number = _CI_number;
    }

    public String get_zd_hod() {
        return _zd_hod;
    }

    public void set_zd_hod(String _zd_hod) {
        this._zd_hod = _zd_hod;
    }

    public String get_zd_modbus_speed() {
        return _zd_modbus_speed;
    }

    public void set_zd_modbus_speed(String _zd_modbus_speed) {
        this._zd_modbus_speed = _zd_modbus_speed;
    }

    public String get_zd_modbus_number() {
        return _zd_modbus_number;
    }

    public void set_zd_modbus_number(String _zd_modbus_number) {
        this._zd_modbus_number = _zd_modbus_number;
    }

    public String get_zd_modbus_setting() {
        return _zd_modbus_setting;
    }

    public void set_zd_modbus_setting(String _zd_modbus_setting) {
        this._zd_modbus_setting = _zd_modbus_setting;
    }

    public String get_zd_max_torque() {
        return _zd_max_torque;
    }

    public void set_zd_max_torque(String _zd_max_torque) {
        this._zd_max_torque = _zd_max_torque;
    }

    public String get_zd_torque_for_close() {
        return _zd_torque_for_close;
    }

    public void set_zd_torque_for_close(String _zd_torque_for_close) {
        this._zd_torque_for_close = _zd_torque_for_close;
    }

    public String get_zd_torque_for_start_open() {
        return _zd_torque_for_start_open;
    }

    public void set_zd_torque_for_start_open(String _zd_torque_for_start_open) {
        this._zd_torque_for_start_open = _zd_torque_for_start_open;
    }

    public String get_zd_torque_for_open() {
        return _zd_torque_for_open;
    }

    public void set_zd_torque_for_open(String _zd_torque_for_open) {
        this._zd_torque_for_open = _zd_torque_for_open;
    }

    public String get_zd_torque_for_start_close() {
        return _zd_torque_for_start_close;
    }

    public void set_zd_torque_for_start_close(String _zd_torque_for_start_close) {
        this._zd_torque_for_start_close = _zd_torque_for_start_close;
    }

    public String get_zd_type() {
        return _zd_type;
    }

    public void set_zd_type(String _zd_type) {
        this._zd_type = _zd_type;
    }

    public String get_zd_time_to_sleep() {
        return _zd_time_to_sleep;
    }

    public void set_zd_time_to_sleep(String _zd_time_to_sleep) {
        this._zd_time_to_sleep = _zd_time_to_sleep;
    }

    public String get_zd_discrete_command() {
        return _zd_discrete_command;
    }

    public void set_zd_discrete_command(String _zd_discrete_command) {
        this._zd_discrete_command = _zd_discrete_command;
    }

    public String get_zd_open_position() {
        return _zd_open_position;
    }

    public void set_zd_open_position(String _zd_open_position) {
        this._zd_open_position = _zd_open_position;
    }

    public String get_zd_close_position() {
        return _zd_close_position;
    }

    public void set_zd_close_position(String _zd_close_position) {
        this._zd_close_position = _zd_close_position;
    }

    public String get_zd_dimens_x() {
        return _zd_dimens_x;
    }

    public void set_zd_dimens_x(String _zd_dimens_x) {
        this._zd_dimens_x = _zd_dimens_x;
    }

    public String get_zd_dimens_y() {
        return _zd_dimens_y;
    }

    public void set_zd_dimens_y(String _zd_dimens_y) {
        this._zd_dimens_y = _zd_dimens_y;
    }

    public String get_zd_pdf_main() {
        return _zd_pdf_main;
    }

    public void set_zd_pdf_main(String _zd_pdf_main) {
        this._zd_pdf_main = _zd_pdf_main;
    }

    public String get_zd_pdf_uso() {
        return _zd_pdf_uso;
    }

    public void set_zd_pdf_uso(String _zd_pdf_uso) {
        this._zd_pdf_uso = _zd_pdf_uso;
    }

    public String get_zd_pdf_main_page() {
        return _zd_pdf_main_page;
    }

    public void set_zd_pdf_main_page(String _zd_pdf_main_page) {
        this._zd_pdf_main_page = _zd_pdf_main_page;
    }

    public String get_zd_pdf_uso_page() {
        return _zd_pdf_uso_page;
    }

    public void set_zd_pdf_uso_page(String _zd_pdf_uso_page) {
        this._zd_pdf_uso_page = _zd_pdf_uso_page;
    }

    public String get_zd_redundant() {
        return _zd_redundant;
    }

    public void set_zd_redundant(String _zd_redundant) {
        this._zd_redundant = _zd_redundant;
    }

    public String get_zd_redundant_2() {
        return _zd_redundant_2;
    }

    public void set_zd_redundant_2(String _zd_redundant_2) {
        this._zd_redundant_2 = _zd_redundant_2;
    }

}

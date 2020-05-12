package teumin.network;

public enum DataType {
    LOGIN_REQUEST,
    // [0] String id
    // [1] String password
    LOGIN_RESPOND,
    // [0] boolean success
    // [1] String nickname
    REGISTER_REQUEST,
    // [0] String id
    // [1] String password
    // [2] String nickname
    REGISTER_RESPOND,
    // [0] boolean success
    FOOD_TRUCK_INQUIRY_REQUEST,
    // [0] String category
    // [1] String address
    FOOD_TRUCK_INQUIRY_RESPOND,
    // [0] boolean null_point
    // [1] String food_truck_name
}
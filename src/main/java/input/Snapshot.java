package input;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Snapshot {

    public Datapoint accelerator_pedal_position;
    public Datapoint brake_pedal_status;
    public Datapoint button_state;
    public Datapoint door_status;
    public Datapoint engine_speed;
    public Datapoint fuel_consumed_since_restart;
    public Datapoint fuel_level;
    public Datapoint headlamp_status;
    public Datapoint ignition_status;
    public Datapoint latitude;
    public Datapoint longitude;
    public Datapoint odometer;
    public Datapoint steering_wheel_angle;
    public Datapoint torque_at_transmission;
    public Datapoint transmission_gear_position;
    public Datapoint vehicle_speed;
    public Datapoint speed_limit;
    public Datapoint windshield_wiper_status;
    public Datapoint turning_lights;

    public Snapshot() {

    }

    public Snapshot(Snapshot snapshot) {

        this.accelerator_pedal_position = snapshot.accelerator_pedal_position;
        this.brake_pedal_status = snapshot.brake_pedal_status;
        this.button_state = snapshot.button_state;
        this.door_status = snapshot.door_status;
        this.engine_speed = snapshot.engine_speed;
        this.fuel_consumed_since_restart = snapshot.fuel_consumed_since_restart;
        this.fuel_level = snapshot.fuel_level;
        this.headlamp_status = snapshot.headlamp_status;
        this.ignition_status = snapshot.ignition_status;
        this.latitude = snapshot.latitude;
        this.longitude = snapshot.longitude;
        this.odometer = snapshot.odometer;
        this.steering_wheel_angle = snapshot.steering_wheel_angle;
        this.torque_at_transmission = snapshot.torque_at_transmission;
        this.transmission_gear_position = snapshot.transmission_gear_position;
        this.vehicle_speed = snapshot.vehicle_speed;
        this.speed_limit = snapshot.speed_limit;
        this.windshield_wiper_status = snapshot.windshield_wiper_status;
        this.turning_lights = snapshot.turning_lights;

    }

    public void addPoint(Datapoint datapoint) {
        switch (datapoint.getDatatype()) {
            case accelerator_pedal_position:
                accelerator_pedal_position = datapoint;
                break;
            case brake_pedal_status:
                brake_pedal_status = datapoint;
                break;
            case button_state:
                button_state = datapoint;
                break;
            case door_status:
                door_status = datapoint;
                break;
            case engine_speed:
                engine_speed = datapoint;
                break;
            case fuel_consumed_since_restart:
                fuel_consumed_since_restart = datapoint;
                break;
            case fuel_level:
                fuel_level = datapoint;
                break;
            case headlamp_status:
                headlamp_status = datapoint;
                break;
            case ignition_status:
                ignition_status = datapoint;
                break;
            case latitude:
                latitude = datapoint;
                break;
            case longitude:
                longitude = datapoint;
                break;
            case odometer:
                odometer = datapoint;
                break;
            case steering_wheel_angle:
                steering_wheel_angle = datapoint;
                break;
            case torque_at_transmission:
                torque_at_transmission = datapoint;
                break;
            case transmission_gear_position:
                transmission_gear_position = datapoint;
                break;
            case vehicle_speed:
                vehicle_speed = datapoint;
                break;
            case speed_limit:
                speed_limit = datapoint;
                break;
            case windshield_wiper_status:
                windshield_wiper_status = datapoint;
                break;
            case turning_lights:
                turning_lights = datapoint;
                break;
        }
    }

    public static String differenceToJson(Snapshot snapshot1, Snapshot snapshot2) throws JsonProcessingException {
        String json = "";
        if(isChanged(snapshot1.accelerator_pedal_position, snapshot2.accelerator_pedal_position))json+=toJson(snapshot1.accelerator_pedal_position);
        if(isChanged(snapshot1.brake_pedal_status, snapshot2.brake_pedal_status))json+=toJson(snapshot1.brake_pedal_status);
        if(isChanged(snapshot1.button_state, snapshot2.button_state))json+=toJson(snapshot1.button_state);
        if(isChanged(snapshot1.door_status, snapshot2.door_status))json+=toJson(snapshot1.door_status);
        if(isChanged(snapshot1.engine_speed, snapshot2.engine_speed))json+=toJson(snapshot1.engine_speed);
        if(isChanged(snapshot1.fuel_consumed_since_restart, snapshot2.fuel_consumed_since_restart))json+=toJson(snapshot1.fuel_consumed_since_restart);
        if(isChanged(snapshot1.fuel_level, snapshot2.fuel_level))json+=toJson(snapshot1.fuel_level);
        if(isChanged(snapshot1.headlamp_status, snapshot2.headlamp_status))json+=toJson(snapshot1.headlamp_status);
        if(isChanged(snapshot1.ignition_status, snapshot2.ignition_status))json+=toJson(snapshot1.ignition_status);
        if(isChanged(snapshot1.latitude, snapshot2.latitude))json+=toJson(snapshot1.latitude);
        if(isChanged(snapshot1.longitude, snapshot2.longitude))json+=toJson(snapshot1.longitude);
        if(isChanged(snapshot1.odometer, snapshot2.odometer))json+=toJson(snapshot1.odometer);
        if(isChanged(snapshot1.steering_wheel_angle, snapshot2.steering_wheel_angle))json+=toJson(snapshot1.steering_wheel_angle);
        if(isChanged(snapshot1.torque_at_transmission, snapshot2.torque_at_transmission))json+=toJson(snapshot1.torque_at_transmission);
        if(isChanged(snapshot1.transmission_gear_position, snapshot2.transmission_gear_position))json+=toJson(snapshot1.transmission_gear_position);
        if(isChanged(snapshot1.vehicle_speed, snapshot2.vehicle_speed))json+=toJson(snapshot1.vehicle_speed);
        if(isChanged(snapshot1.speed_limit, snapshot2.speed_limit))json+=toJson(snapshot1.speed_limit);
        if(isChanged(snapshot1.windshield_wiper_status, snapshot2.windshield_wiper_status))json+=toJson(snapshot1.windshield_wiper_status);
        if(isChanged(snapshot1.turning_lights, snapshot2.turning_lights))json+=toJson(snapshot1.turning_lights);
        return json;
    }

    public static boolean isChanged(Datapoint point1, Datapoint point2) {
        return point1 != null && point2 != null && point1.getValue() != point2.getValue();
    }

    public static String toJson(Datapoint datapoint) throws JsonProcessingException {
        return (new ObjectMapper()).writeValueAsString(datapoint) + '\n';
    }

}

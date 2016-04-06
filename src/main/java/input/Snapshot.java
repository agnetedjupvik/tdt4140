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

    public static String differenceToJson(Snapshot snapshot1, Snapshot snapshot2, ObjectMapper mapper) throws JsonProcessingException {
        String json = "";
        if (isChanged(snapshot1.accelerator_pedal_position, snapshot2.accelerator_pedal_position))
            json += snapshot1.accelerator_pedal_position.toJson(mapper);
        if (isChanged(snapshot1.brake_pedal_status, snapshot2.brake_pedal_status))
            json += snapshot1.brake_pedal_status.toJson(mapper);
        if (isChanged(snapshot1.button_state, snapshot2.button_state))
            json += snapshot1.button_state.toJson(mapper);
        if (isChanged(snapshot1.door_status, snapshot2.door_status))
            json += snapshot1.door_status.toJson(mapper);
        if (isChanged(snapshot1.engine_speed, snapshot2.engine_speed))
            json += snapshot1.engine_speed.toJson(mapper);
        if (isChanged(snapshot1.fuel_consumed_since_restart, snapshot2.fuel_consumed_since_restart))
            json += snapshot1.fuel_consumed_since_restart.toJson(mapper);
        if (isChanged(snapshot1.fuel_level, snapshot2.fuel_level))
            json += snapshot1.fuel_level.toJson(mapper);
        if (isChanged(snapshot1.headlamp_status, snapshot2.headlamp_status))
            json += snapshot1.headlamp_status.toJson(mapper);
        if (isChanged(snapshot1.ignition_status, snapshot2.ignition_status))
            json += snapshot1.ignition_status.toJson(mapper);
        if (isChanged(snapshot1.latitude, snapshot2.latitude))
            json += snapshot1.latitude.toJson(mapper);
        if (isChanged(snapshot1.longitude, snapshot2.longitude))
            json += snapshot1.longitude.toJson(mapper);
        if (isChanged(snapshot1.odometer, snapshot2.odometer))
            json += snapshot1.odometer.toJson(mapper);
        if (isChanged(snapshot1.speed_limit, snapshot2.speed_limit))
            json += snapshot1.speed_limit.toJson(mapper);
        if (isChanged(snapshot1.steering_wheel_angle, snapshot2.steering_wheel_angle))
            json += snapshot1.steering_wheel_angle.toJson(mapper);
        if (isChanged(snapshot1.torque_at_transmission, snapshot2.torque_at_transmission))
            json += snapshot1.torque_at_transmission.toJson(mapper);
        if (isChanged(snapshot1.transmission_gear_position, snapshot2.transmission_gear_position))
            json += snapshot1.transmission_gear_position.toJson(mapper);
        if (isChanged(snapshot1.turning_lights, snapshot2.turning_lights))
            json += snapshot1.turning_lights.toJson(mapper);
        if (isChanged(snapshot1.vehicle_speed, snapshot2.vehicle_speed))
            json += snapshot1.vehicle_speed.toJson(mapper);
        if (isChanged(snapshot1.windshield_wiper_status, snapshot2.windshield_wiper_status))
            json += snapshot1.windshield_wiper_status.toJson(mapper);
        return json;
    }

    public static boolean isChanged(Datapoint point1, Datapoint point2) {
        return point1 != null && point2 != null && point1.getValue() != point2.getValue();
    }

    @Override
    public String toString() {
        return "Snapshot{" +
                "accelerator_pedal_position=" + accelerator_pedal_position +
                ", brake_pedal_status=" + brake_pedal_status +
                ", button_state=" + button_state +
                ", door_status=" + door_status +
                ", engine_speed=" + engine_speed +
                ", fuel_consumed_since_restart=" + fuel_consumed_since_restart +
                ", fuel_level=" + fuel_level +
                ", headlamp_status=" + headlamp_status +
                ", ignition_status=" + ignition_status +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", odometer=" + odometer +
                ", steering_wheel_angle=" + steering_wheel_angle +
                ", torque_at_transmission=" + torque_at_transmission +
                ", transmission_gear_position=" + transmission_gear_position +
                ", vehicle_speed=" + vehicle_speed +
                ", speed_limit=" + speed_limit +
                ", windshield_wiper_status=" + windshield_wiper_status +
                ", turning_lights=" + turning_lights +
                '}';
    }
}

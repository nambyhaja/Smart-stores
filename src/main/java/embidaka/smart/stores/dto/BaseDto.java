/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.dto;

/**
 *
 * @author hjhonata
 */
public class BaseDto {
    private int status;
    private boolean success;
    private String message;
    private String description;

    public BaseDto()
    {
        
    }
    
    public BaseDto(int status, boolean success, String message, String description) {
        this.status = status;
        this.success = success;
        this.message = message;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatusAsSuccess()
    {
        this.setStatus(200);
        this.setSuccess(true);
        this.setMessage("success");
        this.setDescription("success");
    }
    
    public void setStatusAsError()
    {
        this.setStatus(400);
        this.setSuccess(false);
        this.setMessage("error");
        this.setDescription("error");
    }
}

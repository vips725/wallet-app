package com.vipul.Vipul.pos.system.contorller;

import com.vipul.Vipul.pos.system.dto.ProfileDTO;
import com.vipul.Vipul.pos.system.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/register")
        public ResponseEntity<ProfileDTO> registerProfile(@RequestBody   ProfileDTO profileDTO){
            ProfileDTO registeredProfile = profileService.registerProfile(profileDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredProfile);
        }

    @GetMapping("/activate")
        public ResponseEntity<String>activationProfile(@RequestParam String activationToken){
            boolean isActivated = profileService.activateProfile(activationToken);
            if(isActivated){
                return ResponseEntity.ok("Profile activated sucessfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activation token ot found or already used");
            }
        }
}

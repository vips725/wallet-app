package com.vipul.Vipul.pos.system.service;
import com.vipul.Vipul.pos.system.dto.ProfileDTO;
import com.vipul.Vipul.pos.system.entity.ProfileEntity;
import com.vipul.Vipul.pos.system.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final EmailService emailService;

    public ProfileDTO registerProfile(ProfileDTO profileDTO) {
        ProfileEntity newProfile = toEntity(profileDTO);
        newProfile.setActivationToken(UUID.randomUUID().toString());
        newProfile = profileRepository.save(newProfile);
        String activationLink =
                "http://localhost:5000/activate?token="
                        + newProfile.getActivationToken();
       String subject = "Activation your Money Manager account";
       String body = "Click on the following link to activate your account" + activationLink;
       emailService.sendEmail(newProfile.getEmail() ,subject ,body);
        return toDTO(newProfile);
    }
    public ProfileEntity toEntity(ProfileDTO profileDTO) {
        return ProfileEntity.builder()
                .id(profileDTO.getId())
                .fullName(profileDTO.getFullName())
                .email(profileDTO.getEmail())
                .password(profileDTO.getPassword())
                .profileImageUrl(profileDTO.getProfileImageUrl())
                .createdAt(profileDTO.getCreatedAt())
                .updatedAt(profileDTO.getUpdatedAt())
                .build();
    }
    public ProfileDTO toDTO(ProfileEntity profileEntity) {
        return ProfileDTO.builder()
                .id(profileEntity.getId())
                .fullName(profileEntity.getFullName())
                .email(profileEntity.getEmail())
                .profileImageUrl(profileEntity.getProfileImageUrl())
                .createdAt(profileEntity.getCreatedAt())
                .updatedAt(profileEntity.getUpdatedAt())
                .build();
    }
}
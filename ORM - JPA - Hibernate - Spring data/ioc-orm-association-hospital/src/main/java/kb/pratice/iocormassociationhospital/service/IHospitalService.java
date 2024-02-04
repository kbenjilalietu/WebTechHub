package kb.pratice.iocormassociationhospital.service;

import kb.pratice.iocormassociationhospital.entities.Consultation;
import kb.pratice.iocormassociationhospital.entities.Medecin;
import kb.pratice.iocormassociationhospital.entities.Patient;
import kb.pratice.iocormassociationhospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}

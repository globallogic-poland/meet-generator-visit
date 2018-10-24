package meet.generator.visit.dto;

public enum Specialization {

    ALLERGIST("Allergist"),
    IMMUNOLOGIST("Immunologist"),
    ANESTHESIOLOGIST("Anesthesiologist"),
    CARDIOLOGIST("Cardiologist"),
    DERMATOLOGIST("Dermatologist"),
    GASTROENTEROLOGIST("Gastroenterologist"),
    HEMATOLOGIST("Hematologist"),
    ONCOLOGIST("Oncologist"),
    INTERNAL_MEDICINE_PHYSICIAN("Internal Medicine Physician"),
    NEPHROLOGIST("Nephrologist"),
    NEUROLOGIST("Neurologist"),
    NEUROSURGEON("Neurosurgeon"),
    OBSTETRICIAN("Obstetrician"),
    GYNECOLOGIST("Gynecologist"),
    NURSE_MIDWIFERY("Nurse-Midwifery"),
    OCCUPATIONAL_MEDICINE_PHYSICIAN("Occupational Medicine Physician"),
    OPHTHALMOLOGIST("Ophthalmologist"),
    SURGEON("Surgeon"),
    ORTHOPAEDIC_SURGEON("Orthopaedic Surgeon"),
    OTOLARYNGOLOGIST("Otolaryngologist"),
    PATHOLOGIST("Pathologist"),
    PEDIATRICIAN("Pediatrician"),
    PLASTIC_SURGEON("Plastic Surgeon"),
    PODIATRIST("Podiatrist"),
    PSYCHIATRIST("Psychiatrist"),
    PULMONARY_MEDICINE_PHYSICIAN("Pulmonary Medicine Physician"),
    RADIATION_ONCONLOGIST("Radiation Onconlogist"),
    DIAGNOSTIC_RADIOLOGIST("Diagnostic Radiologist"),
    RHEUMATOLOGIST("Rheumatologist"),
    UROLOGIST("Urologist");

    private String displayName;

    Specialization(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
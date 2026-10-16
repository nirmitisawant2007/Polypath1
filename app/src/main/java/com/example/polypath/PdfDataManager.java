package com.example.polypath;

import java.util.List;

public class PdfDataManager {

    public static void getPdfData(String branch, String semester, String subject, String category, List<String> titles, List<String> ids) {
        titles.clear();
        ids.clear();


        //First semester

        if (subject.equals("Basic Mathematics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Syllabus", "1CeeWnba85M2-sT1HDOjBAGDza15P0eZL");
            } else if (category.equals("study material")) {
                addPdf(titles, ids, "Mathematics Notes", "1XlBj43hZKZIgDqkVskL2LpEcr2MAKZUl");
                addPdf(titles, ids, "Mathematics Notes", "19c6xqF_RZQPqVl4Rb95UP64DUZAcWjaR");
                addPdf(titles, ids, "Mathematics Notes", "1ghQ-xkvCCgwnvH1DtVkqe9qcCpEFFQXE");
                addPdf(titles, ids, "Mathematics Notes", "1kgzuuqzxR4QafcDTu0kJ1Vm1CAz8jBQs");
                addPdf(titles, ids, "Mathematics Notes", "1_qE4SpTrrCNBd_0XkuToQeG9_pybW40C");
            }
        }

        else if (subject.equals("English")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "English Syllabus", "1Ydfkohvb9HPfpxbWFAagRUD0bGFiivVx");
            }else if (category.equals("study material")){
                addPdf(titles, ids, "English Notes", "1vMq5Pwu-Mo2qOJCSlpGykfwg0N6f0jzN");
                addPdf(titles, ids, "English Notes", "1AfIjqfA2azX20WP-YzQzQjYJCYDu6W-x");
                addPdf(titles, ids, "English Notes", "1Qb98iVh8cs6e0GaOAVy96_Gcti2RtCnw");
            }else if (category.equals("manual")){
                addPdf(titles, ids, "English Manual", "1_iTykM81NP3GvJaDdh-7h5HN7W_VC7Z-");
            }

        }

        else if (subject.equals("Physics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Physics Syllabus", "10UiDiLa3oKsS0ytzFKO4bMFus7g090l_");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Physics Notes", "1B9d7-dvJpkDa3Bb1_eaOuVDDp0jfsqk0");
                addPdf(titles, ids, "Physics Notes", "1VRo8aerZQZQ8z-RGnN-iTz95Uni5V4Sz");
                addPdf(titles, ids, "Physics Notes", "1DVNAawGCEHqFsTM-vdfZDi0wJOC6CUDm");
                addPdf(titles, ids, "Physics Notes", "1fSIA800cXJK1PQuNLL2TokL93SaiPSJ2");

            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Physics Lab Manual", "19y9OrjuGDrjjS0z1-ucDtrndUquIDxdp");
            }

        }

        else if (subject.equals("Chemistry")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Chemistry Syllabus", "10UiDiLa3oKsS0ytzFKO4bMFus7g090l_");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Chemistry Notes", "1B9d7-dvJpkDa3Bb1_eaOuVDDp0jfsqk0");
                addPdf(titles, ids, "Chemistry Notes", "1VRo8aerZQZQ8z-RGnN-iTz95Uni5V4Sz");
                addPdf(titles, ids, "Chemistry Notes", "1DVNAawGCEHqFsTM-vdfZDi0wJOC6CUDm");
                addPdf(titles, ids, "Chemistry Notes", "1fSIA800cXJK1PQuNLL2TokL93SaiPSJ2");

            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Chemistry Lab Manual", "1ULsS1UL2NdMvynywIaS7iqm2iA1eLVXA");
            }
        }

        else if (subject.equals("Engineering Workshop")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Engineering Workshop", "1dVw5LnITUsjwbu939g-0nN3I6dZd79Az");
            }
            else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Engineering Workshop", " ");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Engineering Workshop Lab Manual", " ");
            }
        }

        else if (subject.equals("Fundamentals of ICT")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Fundamentals of ICT Syllabus", "1ZTyp2buPloI2KAqvXj_nujnDeWZrWkQ4");
            }
            else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Fundamentals of ICT", " ");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Fundamentals of ICT Lab Manual", " ");
            }
        }

        else if (subject.equals("Yoga and Meditation")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Yoga and Meditation Syllabus", "1pu9eibZNeuCLNotJcAwgqd_dDmvk7aBT");
            }
            else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Yoga and Meditation", " ");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Yoga and Meditation Lab Manual", " ");
            }
        }

        if (subject.equals("Engineering Graphics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Engineering Graphics Syllabus", "1eFxLCzz4xImfUe4vhH-m9zknw1wQu_2_");
            }

            else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Engineering Graphics", " ");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Engineering Graphics Lab Manual", " ");
            }
        }

        else if (subject.equals("Basic Electrical and Electronics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Basic Electrical and Electronics Syllabus", "10eFdYZ7t_8p05hyhPc9xPFnEESP0Y7ek");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "basic Electrical and Electronics Notes", "1_Ceeuzp3ra9Rt4ZMmxAX3ZBj4-iIFI-d");
                addPdf(titles, ids, "Basic Electrical and Electronics Notes", "1QWG5274PXakp26Uz1KeBgZXcP1Vgb2IT");
                addPdf(titles, ids, "Basic Electrical and Electronics Notes", "1vbGnJAf4FXlyfSSeQjgGit6J5adaqY7b");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "basic electrical and electronics Lab Manual", "1iznNpbVWQGSWJoHKrMPcPfoHuQ0hgvSB");
            }
        }


        else if (subject.equals("Applied Mathematics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Applied Mathematics Syllabus", "1A8HGFcITJ_MnTIDGaofya65UYXMK7FQZ");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Applied Mathematics Notes", "1t8K9QWJHU5SBF-CKQ3sr1X9SL1oN3ymv");
                addPdf(titles, ids, "Applied Mathematics Notes", "1qYKzr85kdUtRJNCv3lt9f2xjVTF5skLF");
                addPdf(titles, ids, "Applied Mathematics Notes", "1icrnJWcKqJHvZuXDBvBVZEbFhRpAECUT");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Applied Mathematics Lab Manual", " ");
            }
        }

        else if (subject.equals("Basic Electrical and Electronics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Basic Electrical and Electronics Syllabus", "1M2MdcDGSTLwqM_vdB8vgAL8l1l-3pVru");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Basic Electrical and Electronics Notes", "1_Ceeuzp3ra9Rt4ZMmxAX3ZBj4-iIFI-d");
                addPdf(titles, ids, "Basic Electrical and Electronics Notes", "1QWG5274PXakp26Uz1KeBgZXcP1Vgb2IT");
                addPdf(titles, ids, "Basic Electrical and Electronics Notes", "1vbGnJAf4FXlyfSSeQjgGit6J5adaqY7b");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Basic Electrical and Electronics Lab Manual", "1iznNpbVWQGSWJoHKrMPcPfoHuQ0hgvSB");
            }
        }

        else if (subject.equals("Programming in C")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Programming in C Syllabus", "1y1tTb78pv9Cqt9dRVa7WDMHKDycXtxbb");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Programming in C Notes", "1TkioxOceu2Lt01zZv2Cpq80jKIjQWbjL");
                addPdf(titles, ids, "Programming in C Notes", "11VSq3OD5Fwy-NnTz7GBICq-4VOVeairp");
                addPdf(titles, ids, "Programming in C Notes", "1wHYjly6VB07a8m3Ty8RbOatRzeXwXdqf");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Programming in C Lab Manual", "1kePRpwRISTwLOuu-KsOXEf-KrZvOKy3U");
            }
        }

        else if (subject.equals("Linux Basics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Linux Basics Syllabus", "1WL9cdSjmWlZxQ-WA9Hprbg_ZIIsHS4X4");
            }
            else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Linux Basics Notes", "1TkioxOceu2Lt01zZv2Cpq80jKIjQWbjL");
            }

            else if (category.equals("manual")) {
                addPdf(titles, ids, "Linux Basics Lab Manual", "1Mr0eG1NVXT6qTJR9jOoUwpAZqUyYbOxq");
            }
        }

        else if (subject.equals("Professional Communication")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Professional Communication Syllabus", "1TuBH-pi1LFmJhWZYaRe8C5_u-6xZsUFA");
            }
            else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Professional Communication Notes", "1TkioxOceu2Lt01zZv2Cpq80jKIjQWbjL");
            }

            else if (category.equals("manual")) {
                addPdf(titles, ids, "Professional communication Lab Manual", "1XLNcg9lMj3ngOsmtD4tzIrolEKTVCk3t");
            }
        }

        else if (subject.equals("Social and Life Skills")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Social and Life Skills Syllabus", "1LwcaSnmTbZ2TQ64lE65I2CtRnXsnW7-L");
            }
            else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Social and Life Skills Notes", "1TkioxOceu2Lt01zZv2Cpq80jKIjQWbjL");
            }

            else if (category.equals("manual")) {
                addPdf(titles, ids, "Social and Life Skills Lab Manual", "1XLNcg9lMj3ngOsmtD4tzIrolEKTVCk3t");
            }
        }

        else if (subject.equals("Web Page Designing")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Web Page Designing Syllabus", "1jDzeSZJXje-tABfKJu3Zxfcb3VdIMjKr");
            }
            else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Web Page Designing Notes", "1TkioxOceu2Lt01zZv2Cpq80jKIjQWbjL");
            }

            else if (category.equals("manual")) {
                addPdf(titles, ids, "Web Page Designing Lab Manual", "1Hq4Eh-IQm5rKQ3OpwxURqryWDydofo5d");
            }
        }

        else if (subject.equals("Applied Physics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Applied Physics Syllabus", "1bbqojSW1VEaHZiWgFgevIJakW_ABMK_o");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Applied Physics Notes", "1nJSZu2wALf7FLCMZPhJzLrZeIKZQmQ6a");
                addPdf(titles, ids, "Applied Physics Notes", "1ChrV2rEcrynR1kyosyrsAPukQ2_mMt8q");
                addPdf(titles, ids, "Applied Physics Notes", "1w7o7YPyjyW-dFQccIJu13lPuh24ltv5Q");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Applied Physics Lab Manual", "1-NqQRrHyOOI4586EsL1TLHvAADra1vT-");
            }
        }
        else if (subject.equals("Applied Chemistry")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Applied Chemistry Syllabus", "1bbqojSW1VEaHZiWgFgevIJakW_ABMK_o");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Applied Chemistry Notes", "1nJSZu2wALf7FLCMZPhJzLrZeIKZQmQ6a");
                addPdf(titles, ids, "Applied Chemistry Notes", "1ChrV2rEcrynR1kyosyrsAPukQ2_mMt8q");
                addPdf(titles, ids, "Applied Chemistry Notes", "1w7o7YPyjyW-dFQccIJu13lPuh24ltv5Q");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Applied Chemistry Lab Manual", "1QTwf4vJQntXLRfB1BbaLwLo9Uzud1dbp");
            }
        }
        else if (subject.equals("Engineering Mechanics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Engineering Mechanics Syllabus", "1n3Ou2lzOssut-DYk5SfVRKaeXrcHYrev");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Engineering Mechanics Notes", "1x-vaK2fkWSz3UQ_94AdacolNfwRA8XHk");
                addPdf(titles, ids, "Engineering Mechanics Notes", "1pAQ3TA8O8awZtZzCXFq_ffvPvOGzPIuk");
                addPdf(titles, ids, "Engineering Mechanics Notes", "1AV20ey5G2zZarHeX579vRqbYVWGaNlh_");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Engineering Mechanics Lab Manual", "1GUVw8r_1CaEf26tYRCRR5fcHXjEc_xD0");
            }
        }
        else if (subject.equals("Building Material and Construction")) {
            if (category.contains("syllabus")) {
                addPdf(titles, ids, "Building Material and Construction Syllabus", "1zNcOMbsjH1FcKKpuacRvyLa0OZrqi21I");
            } else if (category.contains("study material")) { // Fixed: study material
                addPdf(titles, ids, "Building Material and Construction Notes", "1tKQLuGQ-R7Nb-CpvPeO4gi3iiosFtD0L");
                addPdf(titles, ids, "Building Material and Construction Notes", "1LfRUtuZS1XvpSJeyp_bpQGQlT85_xj2-");
                addPdf(titles, ids, "Building Material and Construction Notes", "1LKqHUKeoPglVKeu2lAsz_c2lvY6_Dqhs");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Building Material and Construction Lab Manual", "17ragZRW_hTgwvcBp92DWZ0MTcbnCKKz3");
            }
        }
        else if (subject.equals("Surveying")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Surveying Syllabus", "1kCEPILcE_gDBNvobAXbtbSS8jPpC47N1");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Surveying Notes", "1KByUxtIYw3e_o1pMYb66BXcEa15gpjiC");
                addPdf(titles, ids, "Surveying Notes", "1sJR6QdYiYubhD6lFfWOFVO4qEzmo4X0-");
                addPdf(titles, ids, "Surveying Notes", "1cmdbe8e5LhxUnuk7Mdnd8cSOgrciLn6U");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "surveying Lab Manual", "1UZAAgW_inGNw6bAzgePZGqfcXUfVFTDr");
            }
        }

        //Electrical
        else if (subject.equals("Elements of Electronics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Elements of  Electronics Syllabus", "1kCpgI1cQDZrV3xUEVp5X2tziP5n_tL_t");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Elements of  Electronics Notes", "1m2hJZ0iDkv4EyGVGXI27nO0GTqwxCr3m");
                addPdf(titles, ids, "Elements of  Electronics Notes", "15R-sJCGPU21Ir3ThhI0axt2bryHjpj5p");
                addPdf(titles, ids, "Elements of  Electronics Notes", "1ZbVe1P9TNmEgvcNfDVwTIGUWWCZd1ngD");
                addPdf(titles, ids, "Elements of  Electronics Notes", "1xZDqeNd4nfYIZucZDa3Ffq-Wpcnl_RQD");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Elements of  Electronics Lab Manual", "1mv2U3ooDqEA2sgMdTUNQvPUaUHIw_ddk");
            }
        }
        else if (subject.equals("Fundamentals of Electrical Engineering")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Fundamentals of Electrical Engineering Syllabus", "1rklnLlfMb3guCcqSIWdIspRhkFt0va1y");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Fundamentals of Electrical Engineering Notes", "1SsnAYG31vuRsSeCz-0V1ayvNasiYBO-X");
                addPdf(titles, ids, "Fundamentals of Electrical Engineering Notes", "13smay1mqK_66MeDAVD8MMf81s4wuI5_w");
                addPdf(titles, ids, "Fundamentals of Electrical Engineering Notes", "16XaS0KjEtTYbS8g42mE1R5MDJHzElVhE");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Fundamentals of Electrical Engineering Lab Manual", "189S34pjcULH5iqw2S0eXH7yTR5SpzKFK");
            }
        }
        else if (subject.equals("Basic Mechanical Engineering")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Basic Mechanical Engineering Syllabus", "1iEmgNbjSWvWWxvykszPsiUkm1VtB17s4");
            }
            else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Basic Mechanical Engineering Notes", " ");
            }

            else if (category.equals("manual")) {
                addPdf(titles, ids, "Basic Mechanical Engineering Lab Manual", "1Fpr_Rs7P32jmeK4rLnQhAod-pXW0nB6Q");
            }
        }

        //Mechanical
        else if (subject.equals("Engineering Drawing")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Engineering Drawing Syllabus", "1YFYylSBEvcel72jzRFG50lk6gRSiezFi");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Engineering Drawing Notes", "1WpYWh-CRclIpPK2oVMqRL88P2P7gkGJ3");
                addPdf(titles, ids, "Engineering Drawing Notes", "1RsNb_4HOAYFDnZpo__lIcWy2wsWV-rD4");
                addPdf(titles, ids, "Engineering Drawing Notes", "1fzXP-4gcVaRYGRNkDc6ZTq2WFSqxvoxA");
            }
            else if (category.equals("manual")) {
                addPdf(titles, ids, "Engineering Drawing Lab Manual", " ");
            }
        }
        else if (subject.equals("Engineering Mechanics")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Engineering Mechanics Syllabus", "10S8NW0ArS9PjvTjP7vPL9kg8YXfK-MlW");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Engineering Mechanics Notes", "1bMP0kSkT6vbqIXiS06rxEC2o460LnXgx");
                addPdf(titles, ids, "Engineering Mechanics Notes", "1cu43naqOY6ptUu1EHp9JupC3ExZoh11r");
                addPdf(titles, ids, "Engineering Mechanics Notes", "1OrrKvNqXyNqlM_aqbUPHn-h7ezT9mu5W");


            } else if (category.equals("manual")) {
                addPdf(titles, ids, "Engineering Mechanics Lab Manual", "1wZhEtllr93uEH7QDEEPlYDf8QCh3AZk2");
            }
        }
        else if (subject.equals("Manufacturing Technology")) {
            if (category.equals("syllabus")) {
                addPdf(titles, ids, "Manufacturing Technology Syllabus", "1UUGKIbsZ0vGeygDaa1mhdWO3cuFG9b7U");
            } else if (category.equals("study material")) { // Fixed: study material
                addPdf(titles, ids, "Manufacturing Technology Notes", "1KG-H4lsNpMYftAl_kFEn8jLmMOdiwWx4");
                addPdf(titles, ids, "Manufacturing Technology Notes", "1HSmZMJ-GhtqSlN-L7j_ohAM4hvKOJ6x8");
                addPdf(titles, ids, "Manufacturing Technology Notes", "1K8xV2Pr41tbtM1DMJOCzuN_RQiamdEGU");


            }
            else if (category.equals("manual")) {
                addPdf(titles, ids, "Manufacturing Technology Lab Manual", "1wZhEtllr93uEH7QDEEPlYDf8QCh3AZk2");
            }
        }



































    }

    private static void addPdf(List<String> titles, List<String> ids, String name, String driveId) {
        titles.add(name);
        ids.add(driveId);
    }
}